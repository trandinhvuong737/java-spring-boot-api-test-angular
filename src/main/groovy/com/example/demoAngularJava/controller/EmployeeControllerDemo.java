package com.example.demoAngularJava.controller;

import com.example.demoAngularJava.dto.Service.EmployeeService;
import com.example.demoAngularJava.entity.EmployeeDemoEntity;
import com.example.demoAngularJava.dto.EmployeeDto;
import java.util.List;
import lombok.AllArgsConstructor;
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
  public List<EmployeeDemoEntity> getAllEmployees() {
    return employeeServer.getAllEmployees();
  }

  @GetMapping("/{id}")
  public EmployeeDemoEntity getEmployeesById(@PathVariable int id) {
    return employeeServer.getEmployeesById(id);
  }

  @PutMapping("/update")
  public void updateEmployee(@RequestBody EmployeeDto employee) {
    employeeServer.updateEmployee(employee);
  }

  @PostMapping("/add")
  public void addEmployee(@RequestBody EmployeeDto employee) {
    employeeServer.addEmployee(employee);
  }

  @DeleteMapping("/{id}")
  public void deleteEmployee(@PathVariable int id) {
    employeeServer.deleteEmployee(id);
  }
}
