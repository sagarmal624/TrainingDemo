package com.sagarandcompany.dockerdemo;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EmployeeValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == Employee.class;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "invalid.name");
        Employee employee = (Employee) target;
        if (employee.getName().equals("Test")) {
            errors.rejectValue("name", "unique.name");
        }
    }
}