package com.sagarandcompany.dockerdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/get/{id}")
    public ResponseDTO get(@PathVariable Long id) {
        return employeeService.get(id);
    }

    @GetMapping("/findByName/{name}")
    public Employee get(@PathVariable String name) {
        return employeeService.findByName(name);
    }

    @GetMapping("/findBySalary")
    public List<Employee> findBySalary(@RequestParam Integer min, @RequestParam Integer max) {
        return employeeService.findBySalary(min, max);
    }

    @GetMapping("/get")
    public List<Employee> getALl() {
        return employeeService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return employeeService.delete(id);
    }
//    @GetMapping("/get")
//    public Employee get(@RequestParam("salary") Integer salary, @RequestParam("name") String name, @RequestParam(value = "id", required = false) Long id) {
//        return new Employee(salary, name, id);
//    }

//    @PostMapping(value = "/save", consumes = "application/json")
//    public Employee save(@RequestBody Employee employee) {
//        return employee;
//    }

    @PostMapping(value = "/save", produces = "application/json")
    public Employee save(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return employee;
    }

    @PostMapping(value = "/save/regular", produces = "application/json")
    public Employee saveRedularEmp(@ModelAttribute RegularEmployee employee) {
        employeeService.save(employee);
        return employee;
    }
    @PostMapping(value = "/save/contarct", produces = "application/json")
    public Employee saveRedularEmp(@ModelAttribute ContractEmployee employee) {
        employeeService.save(employee);
        return employee;
    }
    @PutMapping(value = "/update", produces = "application/json")
    public Employee update(@RequestBody Employee employee) {
        employeeService.save(employee);
        return employee;
    }
}
