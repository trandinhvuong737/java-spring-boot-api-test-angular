package com.example.demoAngularJava.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demoAngularJava.Service.EmployeeServerImpl;
import com.example.demoAngularJava.entity.EmployeeDemoEntity;
import com.example.demoAngularJava.repository.EmployeeRepositoryDemo;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@WebMvcTest(EmployeeControllerTest.class)
@RunWith(SpringRunner.class)
public class EmployeeControllerTest {

  @Mock
  private EmployeeRepositoryDemo employeeRepositoryDemo;

  @MockBean
  EmployeeServerImpl employeeServer;
  @Autowired
  MockMvc mvc;

  @BeforeEach
  public void setup() throws Exception {
    this.employeeServer= new EmployeeServerImpl(employeeRepositoryDemo);
  }

  @DisplayName("find all return status 200 and json array")
  @Test
  public void findAll_whenGetEmployees_thenReturnStatus200AndJsonArray() throws Exception {
    List<EmployeeDemoEntity> employees = new ArrayList<>();
    for(int i = 0; i < 5; i++) {
      employees.add(new EmployeeDemoEntity(i,"vuong", "tran","vuong@123", "nam", 123, 12));
    }
    when(employeeServer.getAllEmployees()).thenReturn(employees);
    this.mvc.perform(get("/employee"))
        .andDo(print())
        .andExpect(status().isOk());
  }

}
