package com.example.demoAngularJava.Service;

import com.example.demoAngularJava.dto.EmployeeDto;
import com.example.demoAngularJava.dto.SortEmployeeDto;
import com.example.demoAngularJava.entity.EmployeeDemoEntity;
import java.util.List;


public interface EmployeeService {

  List<EmployeeDemoEntity> getAllEmployees();
  List<EmployeeDemoEntity> sortEmployees(SortEmployeeDto sortEmployeeDto);

  EmployeeDemoEntity getEmployeesById(int id);

  void updateEmployee(EmployeeDto employeeDto);

  EmployeeDemoEntity addEmployee(EmployeeDto employeeDto);

  void deleteEmployee(int id);
}
