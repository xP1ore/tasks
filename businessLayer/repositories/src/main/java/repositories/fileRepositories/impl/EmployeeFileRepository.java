package repositories.fileRepositories.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.AllArgsConstructor;
import models.Employee;
import repositories.fileRepositories.EntityFileRepository;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
public class EmployeeFileRepository implements EntityFileRepository<Employee> {
    private Gson gson;
    private final File file = new File("employee.json");

    @Override
    public void create(Employee entity) throws IOException {
        List<Employee> employees = getAll();
        employees.add(entity);
        saveAll(employees);
    }

    @Override
    public void update(Employee entity) throws IOException{
        List<Employee> employees = getAll();
        for (Employee employee : employees) {
            if (employee.getId().equals(entity.getId())) {
                employees.remove(employee);
                employees.add(entity);
                saveAll(employees);
                return;
            }
        }
    }

    @Override
    public Employee getById(Long id) throws IOException{
        List<Employee> employees = getAll();
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public void deleteById(Long id) throws IOException {
        List<Employee> employees = getAll();
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                employees.remove(employee);
                saveAll(employees);
                return;
            }
        }
    }

    @Override
    public List<Employee> getAll() throws IOException {
        FileReader reader = new FileReader(file);
        List<Employee> employees = gson.fromJson(reader, new TypeToken<List<Employee>>() {}.getType());
        reader.close();
        if (employees == null) {
            return new ArrayList<>();
        }
        return employees;
    }

    @Override
    public void saveAll(List<Employee> employees) throws IOException {
        FileWriter writer = new FileWriter(file);
        gson.toJson(employees, writer);
        writer.close();
    }
}
