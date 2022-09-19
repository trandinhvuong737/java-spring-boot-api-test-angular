package com.example.demoAngularJava.Service;

import com.example.demoAngularJava.dto.EmployeeDto;
import com.example.demoAngularJava.entity.EmployeeDemoEntity;
import java.util.List;
import org.springframework.data.domain.Sort.Direction;

public interface EmployeeService {

  List<EmployeeDemoEntity> getAllEmployees();
  List<EmployeeDemoEntity> sortEmployees(Direction direction, String filter);

  EmployeeDemoEntity getEmployeesById(int id);

  void updateEmployee(EmployeeDto employeeDto);

  void addEmployee(EmployeeDto employeeDto);

  void deleteEmployee(int id);
}
