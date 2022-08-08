package com.example.accessingdatajpa.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {

    private @Id @GeneratedValue Long id;
    private String name;
    private String role;
    private String reportees;

    public String getReportees() {
        return reportees;
    }

    public void setReportees(String reportees) {
        this.reportees = reportees;
    }



    Employee() {}

    public Employee(String name, String role, String reportees) {

        this.name = name;
        this.role = role;
        this.reportees = reportees;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getRole() {
        return this.role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Employee))
            return false;
        Employee employee = (Employee) o;
        return Objects.equals(this.id, employee.id) && Objects.equals(this.name, employee.name)
                && Objects.equals(this.role, employee.role) && Objects.equals(this.reportees, employee.reportees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.role, this.reportees);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.role + '\'' + ", reportees='" + this.reportees + '\''+ '}';
    }
}
