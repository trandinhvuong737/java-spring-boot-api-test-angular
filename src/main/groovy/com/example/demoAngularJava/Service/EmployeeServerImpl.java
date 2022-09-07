package com.example.demoAngularJava.Service;

import com.example.demoAngularJava.entity.EmployeeDemoEntity;
import com.example.demoAngularJava.repository.EmployeeRepositoryDemo;
import com.example.demoAngularJava.dto.EmployeeDto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServerImpl implements EmployeeService {

  private final EmployeeRepositoryDemo employeeRepositoryDemo;

  public EmployeeServerImpl(EmployeeRepositoryDemo employeeRepositoryDemo) {
    this.employeeRepositoryDemo = employeeRepositoryDemo;
  }

  @Override
  public List<EmployeeDemoEntity> getAllEmployees() {
    return employeeRepositoryDemo.findAll();
  }

  @Override
  public EmployeeDemoEntity getEmployeesById(int id) {
    return employeeRepositoryDemo.findFirstById(id);
  }

  @Override
  public void updateEmployee(EmployeeDto employeeDto) {
    EmployeeDemoEntity employeeDemoEntity = employeeRepositoryDemo.findFirstById(
        employeeDto.getId());
    employeeDemoEntity.setFirstName(employeeDto.getFirstName());
    employeeDemoEntity.setLastName(employeeDto.getLastName());
    employeeDemoEntity.setAge(employeeDto.getAge());
    employeeDemoEntity.setEmail(employeeDto.getEmail());
    employeeDemoEntity.setGender(employeeDto.getGender());
    employeeDemoEntity.setPhoneNumber(employeeDto.getPhoneNumber());
    employeeRepositoryDemo.save(employeeDemoEntity);
  }

  @Override
  public void addEmployee(EmployeeDto employeeDto) {
    EmployeeDemoEntity employeeDemoEntity = new EmployeeDemoEntity();
    employeeDemoEntity.setFirstName(employeeDto.getFirstName());
    employeeDemoEntity.setLastName(employeeDto.getLastName());
    employeeDemoEntity.setAge(employeeDto.getAge());
    employeeDemoEntity.setEmail(employeeDto.getEmail());
    employeeDemoEntity.setGender(employeeDto.getGender());
    employeeDemoEntity.setPhoneNumber(employeeDto.getPhoneNumber());
    employeeRepositoryDemo.save(employeeDemoEntity);
  }

  @Override
  public void deleteEmployee(int id) {
    employeeRepositoryDemo.deleteById(id);
  }
}
