package com.sagarandcompany.dockerdemo.beansscope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class UserService {
    private String name;
    private String email;
    private Integer salary;
    private Address address;

    @Autowired
    ApplicationContext applicationContext;

     public Address getAddress() {
         System.out.println("sadasdada");
//        Address address = (Address) applicationContext.getBean("address");
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "UserService{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                '}';
    }
}
