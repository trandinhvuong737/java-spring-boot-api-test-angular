package com.example.demoAngularJava.repository;

import com.example.demoAngularJava.entity.EmployeeDemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositoryDemo extends JpaRepository<EmployeeDemoEntity, Integer> {

  EmployeeDemoEntity findFirstById(int id);
}
