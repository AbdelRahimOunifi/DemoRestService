package com.example.DemoRestServices.DemoRestServices.Data;

import com.example.DemoRestServices.DemoRestServices.Models.Employee;
import com.example.DemoRestServices.DemoRestServices.Repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadData {


    @Bean
    CommandLineRunner initDataBase(EmployeeRepository repository){
        return args -> {
            log.info("Preloading"+ repository.save( new Employee("ounifi AbdelRahim","admin")));
            log.info("Preloading"+ repository.save( new Employee("Khaskousi Wissem","admin")));
        };
    }
}
