package com.employee.crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    @PastOrPresent(message = "date of joining cannot be in the future")
    private LocalDate doj;

    // use wrapper types so null means 'not provided' during partial updates
    @Column(name = "status")
    private Integer status;

    @Column(name = "salary")
    private Float salary;

    public Employee() {
    }

    public Employee(Long id, String name, LocalDate doj, Integer status, Float salary) {
        this.id = id;
        this.doj = doj;
        this.name = name;
        this.salary = salary;
        this.status = status;
    }

    public Employee(String name, LocalDate doj, Integer status, Float salary) {
        this.doj = doj;
        this.name = name;
        this.salary = salary;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
