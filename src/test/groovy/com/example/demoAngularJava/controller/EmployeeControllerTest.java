package com.example.demoAngularJava.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demoAngularJava.Service.EmployeeServerImpl;
import com.example.demoAngularJava.dto.EmployeeDto;
import com.example.demoAngularJava.dto.SortEmployeeDto;
import com.example.demoAngularJava.entity.EmployeeDemoEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@WebMvcTest(EmployeeControllerDemo.class)
@RunWith(SpringRunner.class)
public class EmployeeControllerTest {

  @MockBean
  EmployeeServerImpl employeeServer;
  @Autowired
  MockMvc mvc;

  public static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    }catch (Exception e) {
      throw new RuntimeException(e);
    }
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
        .andExpect(status().isOk());
  }

  @DisplayName("sort all return status 200 and json array")
  @Test
  public void sortEmployees_whenPostSortEmployeeDto_thenReturnStatus200AndJsonArray() throws Exception {
    List<EmployeeDemoEntity> employees = new ArrayList<>();
    for(int i = 0; i < 5; i++) {
      employees.add(new EmployeeDemoEntity(i,"vuong", "tran","vuong@123", "nam", 123, 12));
    }
    SortEmployeeDto sort = new SortEmployeeDto();
    sort.setDirection(Direction.ASC);
    sort.setFilter("id");
    when(employeeServer.sortEmployees(any(SortEmployeeDto.class))).thenReturn(employees);
    this.mvc.perform(post("/employee/sort")
            .content(asJsonString(sort))
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @DisplayName("creat employee return status 200 and json array")
  @Test
  public void creatEmployee_whenPostEmployee_thenReturnStatus200AndJsonArray() throws Exception {
    EmployeeDto employeeDto = new EmployeeDto();
    employeeDto.setAge(12);
    employeeDto.setEmail("vuong@123.com");
    employeeDto.setGender("nam");
    employeeDto.setLastName("vuong");
    employeeDto.setLastName("tran dinh");
    employeeDto.setPhoneNumber(132154564);

    EmployeeDemoEntity employeeDemoEntity = new EmployeeDemoEntity();
    employeeDto.setId(1);
    employeeDto.setAge(12);
    employeeDto.setEmail("vuong@123.com");
    employeeDto.setGender("nam");
    employeeDto.setLastName("vuong");
    employeeDto.setLastName("tran dinh");
    employeeDto.setPhoneNumber(132154564);

    when(employeeServer.addEmployee(any(EmployeeDto.class))).thenReturn(employeeDemoEntity);
    this.mvc.perform(post("/employee/add")
            .content(asJsonString(employeeDto))
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }
}
