package com.sagarandcompany.dockerdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }


    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    //
    public Employee get(Long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public Employee findByName(String name) {
        Optional<Employee> optional = employeeRepository.findByName(name);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public List<Employee> findBySalary(Integer min, Integer max) {
        return employeeRepository.findAllBySalaryBetweenOrderByNameAsc(min, max);
    }

    public String delete(Long id) {
        employeeRepository.deleteById(id);
        return "Deleted Successfully";
    }
}

