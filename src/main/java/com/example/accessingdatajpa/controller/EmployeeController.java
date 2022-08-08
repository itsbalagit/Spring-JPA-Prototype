package com.example.accessingdatajpa.controller;

import java.util.List;

import com.example.accessingdatajpa.exception.EmployeeNotFoundException;
import com.example.accessingdatajpa.helper.EmployeeInterfaceImpl;
import com.example.accessingdatajpa.interfaces.EmployeeInterface;
import com.example.accessingdatajpa.model.Employee;
import com.example.accessingdatajpa.repository.EmployeeRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class EmployeeController {

    private final EmployeeRepository repository;
    private final EmployeeInterface empInterface;

    EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
        empInterface = new EmployeeInterfaceImpl(repository);
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/employees")
    List<Employee> all() {
        return empInterface.all();
    }
    // end::get-aggregate-root[]

    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return empInterface.newEmployee(newEmployee);
    }

    // Single item

    @GetMapping("/employees/{id}")
    Employee one(@PathVariable Long id) {
        return empInterface.one(id);
    }

    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
        return empInterface.replaceEmployee(newEmployee, id);
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/employees/findLeads")
    List<Employee> findLeads() {
        return empInterface.findLeads();
    }

    @PutMapping("/employees/findLeadAndUpdate")
    Employee findLeadAndUpdate() {
        return empInterface.findLeadAndUpdate();
    }
}
