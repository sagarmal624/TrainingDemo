package com.sagarandcompany.dockerdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/get/{id}")
    public Employee get(@PathVariable Long id) {
        return employeeService.get(id);
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

    @PostMapping(value = "/save", produces = "application/xml")
    public Employee save(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return employee;
    }
}
