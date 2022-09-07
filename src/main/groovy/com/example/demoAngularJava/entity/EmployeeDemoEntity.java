package com.example.demoAngularJava.entity;

import java.util.UUID;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "employee")
@Access(AccessType.FIELD)
@ToString
@RequiredArgsConstructor
@Setter
@Getter
@Builder
public class EmployeeDemoEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;
  @Column(name = "email")
  private String email;
  @Column(name = "gender")
  private String gender;
  @Column(name = "phone_number")
  private int phoneNumber;
  @Column(name = "age")
  private int age;

  public EmployeeDemoEntity(int id, String firstName, String lastName, String email, String gender,
      int phoneNumber, int age) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.gender = gender;
    this.phoneNumber = phoneNumber;
    this.age = age;
  }
}
