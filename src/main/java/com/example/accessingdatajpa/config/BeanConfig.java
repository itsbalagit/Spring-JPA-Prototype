package com.example.accessingdatajpa.config;

import com.example.accessingdatajpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Autowired
    EmployeeRepository employeeRepository;

}
