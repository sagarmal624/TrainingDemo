package com.sagarandcompany.dockerdemo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("RegularEmployee")
@Entity
public class RegularEmployee extends Employee {
    private Integer bouns;

    public Integer getBouns() {
        return bouns;
    }

    public void setBouns(Integer bouns) {
        this.bouns = bouns;
    }
}
