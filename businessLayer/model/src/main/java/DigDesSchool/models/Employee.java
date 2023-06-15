package DigDesSchool.models;

import DigDesSchool.enums.EmployeeStatus;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@RequiredArgsConstructor
@Builder
@Data
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeIdSequence")
    private Long id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "employeeStatus", nullable = false)
    @Enumerated(EnumType.STRING)
    private EmployeeStatus status; // статус пользователя из enum MemberStatus

    @Column(name = "emailAddress")
    private String emailAddress;
}
