package com.sagarandcompany.dockerdemo;

import javax.persistence.Entity;

@Entity
public class ContractEmployee extends Employee {
    private Integer time;

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}
