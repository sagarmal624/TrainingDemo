package com.sagarandcompany.dockerdemo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private static List<Employee> employeeList = new ArrayList<>();

    public Employee save(Employee employee) {
        employeeList.add(employee);
        return employee;
    }

    public List<Employee> getAll() {
        return employeeList;
    }

    public Employee get(Long id) {
        Optional<Employee> employee = employeeList.stream().filter(it -> it.getId().equals(id)).findFirst();
        if (employee.isPresent()) {
            return employee.get();
        } else
            return null;
    }

    public String delete(Long id) {
        return employeeList.removeIf(it -> it.getId().equals(id)) ? "Deleted" : "Not FOund";
    }
}

