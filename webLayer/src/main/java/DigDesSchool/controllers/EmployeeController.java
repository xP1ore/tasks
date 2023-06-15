package DigDesSchool.controllers;

import DigDesSchool.dto.employee.input.CreateEmployeeDto;
import DigDesSchool.dto.employee.input.ModifyEmployeeDto;
import DigDesSchool.dto.employee.output.OutputEmployeeDto;
import DigDesSchool.services.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
@Log4j2
@Tag(name = "EmployeeController", description = "Контроллер сотрудников")
public class EmployeeController {

    EmployeeService employeeService;

    @Operation(summary = "Создание записи сотрудника")
    @PostMapping(value = "create/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public OutputEmployeeDto create(@RequestBody CreateEmployeeDto newEmployee) {
        log.info("Метод Employee::create");
        return employeeService.createNewEmployee(newEmployee);
    }

    @Operation(summary = "Удаление записи сотрудника")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public OutputEmployeeDto delete(@PathVariable Long id) {
        log.info("Метод Employee::delete");
        return employeeService.deleteEmployee(id);
    }

    @Operation(summary = "Изменение записи сотрудника")
    @PutMapping(value = "/edit", consumes = MediaType.APPLICATION_JSON_VALUE)
    public OutputEmployeeDto edit(@RequestBody ModifyEmployeeDto employeeToModify) throws IllegalAccessException{
        log.info("Метод Employee::edit");
        return employeeService.modifyEmployee(employeeToModify);
    }

    @Operation(summary = "Получение записи сотрудника по id")
    @GetMapping(value = "/get_by_id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public OutputEmployeeDto getById(@PathVariable Long id) {
        log.info("Метод Employee::getById");
        return employeeService.getEmployeeById(id);
    }

    @Operation(summary = "Поиск сотрудника")
    @GetMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OutputEmployeeDto> find(@RequestParam String filter) {
        log.info("Метод Employee::find");
        return employeeService.findEmployees(filter);
    }

}
