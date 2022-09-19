package com.example.demoAngularJava.dto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort.Direction;

@Getter
@Setter
public class SortEmployeeDto {

  Direction direction;
  String filter;

}
