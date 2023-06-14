package models;

import enums.EmployeeStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Builder
@Setter
@Getter
public class Employee implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private EmployeeStatus status; // статус пользователя из enum MemberStatus
    private String emailAddress; // адрес электронной почты сотрудника
}
