package com.example.demoAngularJava.Service;

import com.example.demoAngularJava.dto.SortEmployeeDto;
import com.example.demoAngularJava.entity.EmployeeDemoEntity;
import com.example.demoAngularJava.exception.EmployeeNotFoundException;
import com.example.demoAngularJava.repository.EmployeeRepositoryDemo;
import com.example.demoAngularJava.dto.EmployeeDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServerImpl implements EmployeeService {

  @Autowired
  private final EmployeeRepositoryDemo employeeRepositoryDemo;

  public EmployeeServerImpl(EmployeeRepositoryDemo employeeRepositoryDemo) {
    this.employeeRepositoryDemo = employeeRepositoryDemo;
  }

  @Override
  public List<EmployeeDemoEntity> getAllEmployees() {
    return employeeRepositoryDemo.findAll();
  }

  @Override
  public List<EmployeeDemoEntity> sortEmployees(SortEmployeeDto sortEmployeeDto) {
    return employeeRepositoryDemo.findAll(
        Sort.by(sortEmployeeDto.getDirection(), sortEmployeeDto.getFilter()));
  }

  @Override
  public EmployeeDemoEntity getEmployeesById(int id) {
    return employeeRepositoryDemo.findFirstById(id).orElseThrow(EmployeeNotFoundException::new);
  }

  @Override
  public void updateEmployee(EmployeeDto employeeDto) {
    EmployeeDemoEntity employeeDemoEntity = employeeRepositoryDemo.findFirstById(
        employeeDto.getId()).orElseThrow(EmployeeNotFoundException::new);
    employeeDemoEntity.setFirstName(employeeDto.getFirstName());
    employeeDemoEntity.setLastName(employeeDto.getLastName());
    employeeDemoEntity.setAge(employeeDto.getAge());
    employeeDemoEntity.setEmail(employeeDto.getEmail());
    employeeDemoEntity.setGender(employeeDto.getGender());
    employeeDemoEntity.setPhoneNumber(employeeDto.getPhoneNumber());
    employeeRepositoryDemo.save(employeeDemoEntity);
  }

  @Override
  public EmployeeDemoEntity addEmployee(EmployeeDto employeeDto) {
    EmployeeDemoEntity employeeDemoEntity = new EmployeeDemoEntity();
    employeeDemoEntity.setFirstName(employeeDto.getFirstName());
    employeeDemoEntity.setLastName(employeeDto.getLastName());
    employeeDemoEntity.setAge(employeeDto.getAge());
    employeeDemoEntity.setEmail(employeeDto.getEmail());
    employeeDemoEntity.setGender(employeeDto.getGender());
    employeeDemoEntity.setPhoneNumber(employeeDto.getPhoneNumber());
    employeeRepositoryDemo.save(employeeDemoEntity);
    return employeeDemoEntity;
  }

  @Override
  public void deleteEmployee(int id) {
    employeeRepositoryDemo.deleteById(id);
  }
}
