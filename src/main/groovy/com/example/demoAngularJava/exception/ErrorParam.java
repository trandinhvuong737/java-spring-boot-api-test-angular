package com.example.demoAngularJava.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorParam {

  private static final long serialVersionUID = 1L;
  private String field;

  public ErrorParam() {

  }

  public ErrorParam(String field) {
    this.field = field;
  }

  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }
}
