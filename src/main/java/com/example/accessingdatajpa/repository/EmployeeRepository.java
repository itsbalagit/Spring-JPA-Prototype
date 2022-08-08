package com.example.accessingdatajpa.repository;

import com.example.accessingdatajpa.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT e.* FROM EMPLOYEE e WHERE e.reportees IS NOT NULL", nativeQuery = true)
    List<Employee> findEmployeeHasReportee();
}
