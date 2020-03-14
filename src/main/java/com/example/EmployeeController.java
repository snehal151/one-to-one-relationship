package com.example;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    private  EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody JsonNode requestBody){
        employeeRepository.findAll();
        Employee employee = new Employee();

        employee.setName(requestBody.get("name").asText());
        employee.setDesignation(requestBody.get("designation").asText());
        employee.setSalary(requestBody.get("salary").asInt());

        Company company = new Company();
        company.setCompanyName(requestBody.get("companyName").asText());
        company.setAddress(requestBody.get("address").asText());

        employee.setCompany(company);
        company.setEmployee(employee);

        return employeeRepository.save(employee);

    }

    @GetMapping("{/id}")
    public Employee getEmployee(@PathVariable Integer id){
        return employeeRepository.findById(id).get();
    }
}
