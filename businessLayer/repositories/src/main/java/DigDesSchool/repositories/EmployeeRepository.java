package DigDesSchool.repositories;

import DigDesSchool.enums.EmployeeStatus;
import DigDesSchool.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public List<Employee> findByEmployeeStatusAndFirstNameContainingOrLastNameContainingOrEmailAddressContaining(
            EmployeeStatus employeeStatus,
            String infixFirstName,
            String infixLastName,
            String infixEmailAddress
    );
}
