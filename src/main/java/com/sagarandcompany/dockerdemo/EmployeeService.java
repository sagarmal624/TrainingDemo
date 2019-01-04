package com.sagarandcompany.dockerdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @PersistenceContext
    EntityManager entityManager;

    public Employee save(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }


    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Transactional
    public ResponseDTO get(Long id) {
        ResponseDTO responseDTO = new ResponseDTO(false, "REcord Not found");
        responseDTO.setData(employeeRepository.findById(id).get());
        return responseDTO;
    }

    public Employee findByName(String name) {
        Optional<Employee> optional = employeeRepository.findByName(name);
        Optional<Employee> optiona2 = employeeRepository.findByName(name);
        Optional<Employee> optiona3 = employeeRepository.findByName(name);
        return optional.get();
    }

    public List<Employee> findBySalary(Integer min, Integer max) {
        return employeeRepository.findAllBySalaryBetweenOrderByNameAsc(min, max);
    }

    public String delete(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent())
            employeeRepository.deleteById(id);
        else
            throw new RecordNotFoundException("Emp Record is not found with id " + id);
        return "Deleted Successfully";
    }
}

