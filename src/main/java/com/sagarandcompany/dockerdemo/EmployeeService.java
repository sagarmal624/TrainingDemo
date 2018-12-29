package com.sagarandcompany.dockerdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
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

    public ResponseDTO get(Long id) {
        ResponseDTO responseDTO = new ResponseDTO(false, "REcord Not found");
//        Session session = entityManager.unwrap(Session.class);
        //     Employee employee = employeeRepository.findById(id).get();
//        session.evict(employee);
//        Employee employee2 = employeeRepository.findById(id).get();
//        session.evict(employee2);
//        Employee employee3 = employeeRepository.findById(id).get();
        //   employeeRepository.save(employee);

        Employee employee = entityManager.find(Employee.class, id, LockModeType.PESSIMISTIC_WRITE);
        responseDTO.setStatus(true);
        responseDTO.setMessage("Found");
        Employee emp = new Employee();
        emp.setId(employee.getId());
        emp.setName(employee.getName());
        responseDTO.setData(emp);
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
        employeeRepository.deleteById(id);
        return "Deleted Successfully";
    }
}

