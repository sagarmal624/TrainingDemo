package com.sagarandcompany.dockerdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    MessageSource messageSource;

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
    public ResponseDTO save(@Valid @ModelAttribute Employee employee, BindingResult bindingResult) {
        new EmployeeValidator().validate(employee, bindingResult);
        if (bindingResult.hasErrors()) {
            return UtilValidator.getErrors(bindingResult, messageSource);
        }
        employeeService.save(employee);
        return null;

    }

    @PutMapping(value = "/update", produces = "application/json")
    public Employee update(@RequestBody Employee employee) {
        employeeService.save(employee);
        return employee;
    }
}
