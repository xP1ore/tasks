package dao;

import dao.util.ConnectionUtil;
import dto.employee.input.EmployeeFilterDto;
import enums.EmployeeStatus;
import models.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    private static final String INSERT_EMPLOYEE = "INSERT INTO employee (firstName, lastName, employeeStatus, emailAddress) " +
            "VALUES (?, ?, ?, ?)";
    private static final String SELECT_EMPLOYEE_BY_ID = "SELECT * FROM employee WHERE id = ?";
    private static final String SELECT_ALL_EMPLOYEE = "SELECT * FROM employee";
    private static final String UPDATE_EMPLOYEE = "UPDATE employee SET firstName = ?, lastName = ?, employeeStatus = ? " +
            "WHERE id = ?";
    private static final String DELETE_EMPLOYEE = "DELETE FROM employee WHERE id = ?";
    private static final String SELECT_EMPLOYEE_BY_FILTER =
            "SELECT * FROM employee e JOIN employee_details ed ON e.id = ed.employee_id WHERE e.firstName = ? " +
                    "AND e.lastName = ? AND ed.employeeStatus = ? AND ed.emailAddress = ?";

    public Employee getById(Long id) throws SQLException {
        try (Connection conn = ConnectionUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(SELECT_EMPLOYEE_BY_ID)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToUser(resultSet);
                }
                return null;
            }
        }
    }

    public List<Employee> getAll() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        try (Connection conn = ConnectionUtil.getConnection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_EMPLOYEE)) {
            while (resultSet.next()) {
                employees.add(mapResultSetToUser(resultSet));
            }
            return employees;
        }
    }

    public void create(Employee employee) throws SQLException {
        try (Connection conn = ConnectionUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(INSERT_EMPLOYEE, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getStatus().toString());
            statement.setString(4, employee.getEmailAddress());
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    employee.setId(generatedKeys.getLong(1));
                }
            }
        }
    }

    public void update(Employee employee) throws SQLException {
        try (Connection conn = ConnectionUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(UPDATE_EMPLOYEE)) {
                statement.setString(1, employee.getFirstName());
                statement.setString(2, employee.getLastName());
                statement.setString(3, employee.getStatus().toString());
                statement.setString(4, employee.getEmailAddress());
                statement.executeUpdate();
        }
    }

    public void delete(Long id) throws SQLException {
        try (Connection conn = ConnectionUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(DELETE_EMPLOYEE)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        }
    }

    public List<Employee> getByFilter(EmployeeFilterDto filter) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        try (Connection conn = ConnectionUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(SELECT_EMPLOYEE_BY_FILTER)) {
            statement.setString(1, filter.firstName);
            statement.setString(2, filter.lastName);
            statement.setString(3, filter.status.toString());
            statement.setString(4, filter.emailAddress);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    employees.add(mapResultSetToUser(resultSet));
                }
            }
        }
        return employees;
    }

    private Employee mapResultSetToUser(ResultSet resultSet) throws SQLException {
        return Employee.builder()
                .id(resultSet.getLong("id"))
                .firstName(resultSet.getString("firstName"))
                .lastName(resultSet.getString("lastName"))
                .status(EmployeeStatus.valueOf(resultSet.getString("employeeStatus")))
                .build();
    }
}
