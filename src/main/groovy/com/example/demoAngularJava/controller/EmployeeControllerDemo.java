package com.example.demoAngularJava.controller;

import com.example.demoAngularJava.Service.EmployeeService;
import com.example.demoAngularJava.dto.SortEmployeeDto;
import com.example.demoAngularJava.entity.EmployeeDemoEntity;
import com.example.demoAngularJava.dto.EmployeeDto;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor

public class EmployeeControllerDemo {

  private final EmployeeService employeeServer;

  @GetMapping
  public ResponseEntity<List<EmployeeDemoEntity>> getAllEmployees() {
    return ResponseEntity.ok().body(employeeServer.getAllEmployees());
  }

  @PostMapping("/sort")
  public ResponseEntity<List<EmployeeDemoEntity>> sortEmployees(@RequestBody SortEmployeeDto sortEmployeeDto) {
    if (sortEmployeeDto.getDirection().equals(Direction.ASC)) {
      return ResponseEntity.ok().body(employeeServer.sortEmployees(sortEmployeeDto));
    } else {
      return ResponseEntity.ok().body(employeeServer.sortEmployees(sortEmployeeDto));
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<EmployeeDemoEntity> getEmployeesById(@PathVariable int id) {
    return ResponseEntity.ok().body(employeeServer.getEmployeesById(id));
  }

  @PutMapping("/update")
  public ResponseEntity updateEmployee(@RequestBody EmployeeDto employee) {
    employeeServer.updateEmployee(employee);
    return ResponseEntity.ok().build();
  }

  @PostMapping("/add")
  public ResponseEntity<EmployeeDemoEntity> addEmployee(@RequestBody EmployeeDto employee) {
    return ResponseEntity.ok().body(employeeServer.addEmployee(employee));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteEmployee(@PathVariable int id) {
    employeeServer.deleteEmployee(id);
    return ResponseEntity.ok().build();
  }
}
