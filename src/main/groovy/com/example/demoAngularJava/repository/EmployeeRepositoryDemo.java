package com.example.demoAngularJava.repository;

import com.example.demoAngularJava.entity.EmployeeDemoEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositoryDemo extends JpaRepository<EmployeeDemoEntity, Integer> {


  Optional<EmployeeDemoEntity> findFirstById(int id);
  List<EmployeeDemoEntity> findAll();
}
