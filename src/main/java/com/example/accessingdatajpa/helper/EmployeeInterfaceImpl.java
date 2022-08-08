package com.example.accessingdatajpa.helper;

import com.example.accessingdatajpa.exception.EmployeeNotFoundException;
import com.example.accessingdatajpa.interfaces.EmployeeInterface;
import com.example.accessingdatajpa.model.Employee;
import com.example.accessingdatajpa.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeInterfaceImpl implements EmployeeInterface {

    private EmployeeRepository employeeRepository;


    public EmployeeInterfaceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> all() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee newEmployee(Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    @Override
    public Employee one(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @Override
    public Employee replaceEmployee(Employee newEmployee, Long id) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return employeeRepository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return employeeRepository.save(newEmployee);
                });
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findLeads() {
        return employeeRepository.findEmployeeHasReportee();
    }

    @Override
    public Employee findLeadAndUpdate() {
        List<Employee> employeeList = employeeRepository.findAll();
        if(employeeList != null){
            for(Employee e : employeeList){
                if(e.getRole().equals("LEAD")){
                    e.setReportees("YES");
                    employeeRepository.save(e);
                    return e;
                }
            }
        }
        return null;
    }
}
