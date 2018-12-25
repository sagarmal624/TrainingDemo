package com.sagarandcompany.dockerdemo;

public class Employee {
    private Integer salary;
    private String name;
    private Long id;

    public Employee() {

    }

    public Employee(Integer salary, String name, Long id) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
