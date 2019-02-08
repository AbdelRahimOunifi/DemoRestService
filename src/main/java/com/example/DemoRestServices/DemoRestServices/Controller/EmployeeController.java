package com.example.DemoRestServices.DemoRestServices.Controller;

import com.example.DemoRestServices.DemoRestServices.Error.EmployeeNotFoundException;
import com.example.DemoRestServices.DemoRestServices.Models.Employee;
import com.example.DemoRestServices.DemoRestServices.Repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping({"","/"})
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @PostMapping("/employee")
    public Employee newEmployee(@RequestAttribute Employee employee) {
        return repository.save(employee);
    }

    @GetMapping("/employees/{id}")
    Employee one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
