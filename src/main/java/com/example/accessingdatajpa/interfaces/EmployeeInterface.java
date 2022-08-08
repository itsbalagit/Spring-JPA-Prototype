package com.example.accessingdatajpa.interfaces;

import com.example.accessingdatajpa.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface EmployeeInterface {
    List<Employee> all();
    Employee newEmployee(@RequestBody Employee newEmployee);
    Employee one(@PathVariable Long id);
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id);
    void deleteEmployee(@PathVariable Long id);
    List<Employee> findLeads();
    Employee findLeadAndUpdate();
}
