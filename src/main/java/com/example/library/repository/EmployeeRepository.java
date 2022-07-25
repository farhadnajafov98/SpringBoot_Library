package com.example.library.repository;

import com.example.library.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllByActive(Integer active);
    Employee findEmployeeByIdAndActive(Long id, Integer active);
}
