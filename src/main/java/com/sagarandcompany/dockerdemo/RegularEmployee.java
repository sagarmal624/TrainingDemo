package com.sagarandcompany.dockerdemo;

import javax.persistence.Entity;

@Entity
//@AttributeOverrides({@AttributeOverride(name = "name", column = @Column(name = "name"))})
public class RegularEmployee extends Employee {
    private Integer bouns;

    public Integer getBouns() {
        return bouns;
    }

    public void setBouns(Integer bouns) {
        this.bouns = bouns;
    }
}
