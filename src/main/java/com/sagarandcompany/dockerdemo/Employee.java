package com.sagarandcompany.dockerdemo;

import javax.persistence.*;

@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {
    @Id
//    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private Integer salary;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
