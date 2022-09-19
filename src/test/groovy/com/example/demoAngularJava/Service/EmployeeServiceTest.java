package com.example.demoAngularJava.Service;

import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.demoAngularJava.entity.EmployeeDemoEntity;
import com.example.demoAngularJava.exception.EmployeeNotFoundException;
import com.example.demoAngularJava.repository.EmployeeRepositoryDemo;
import java.util.ArrayList;


import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

  @Mock
  private EmployeeRepositoryDemo employeeRepositoryDemo;

  @InjectMocks
  private EmployeeServerImpl employeeServer;

  @Test
  void whenGetAll_shouldReturnList() {
    // 1. create mock data
    List<EmployeeDemoEntity> mockEmployees = new ArrayList<>();
    for(int i = 0; i < 5; i++) {
      mockEmployees.add(new EmployeeDemoEntity(i,"vuong", "tran","vuong@123", "nam", 123, 12));
    }

    // 2. define behavior of Repository
    when(employeeRepositoryDemo.findAll()).thenReturn(mockEmployees);

    // 3. call service method
    List<EmployeeDemoEntity> actualEmployee = employeeServer.getAllEmployees();

    // 4. assert the result
    assertThat(actualEmployee.size()).isEqualTo(mockEmployees.size());

    // 4.1 ensure repository is called
    verify(employeeRepositoryDemo).findAll();
  }

  @Test
  void whenGetInvalidOne_shouldThrowException() {
    Integer id =1;
    when(employeeRepositoryDemo.findFirstById(any(Integer.class))).thenReturn(Optional.ofNullable(null));

    assertThatThrownBy(() -> employeeServer.getEmployeesById(id))
        .isInstanceOf(EmployeeNotFoundException.class);

    verify(employeeRepositoryDemo).findFirstById(any(Integer.class));
  }
}
