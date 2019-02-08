package com.example.DemoRestServices.DemoRestServices.Repository;

import com.example.DemoRestServices.DemoRestServices.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends  JpaRepository<Employee, Long> {
}
