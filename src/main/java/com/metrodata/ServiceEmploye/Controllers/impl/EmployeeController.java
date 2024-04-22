package com.metrodata.ServiceEmploye.Controllers.impl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metrodata.ServiceEmploye.Services.impl.ServiceEmployeeImpl;
import java.util.List;
import com.metrodata.ServiceEmploye.Models.Entity.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private ServiceEmployeeImpl serviceEmployeeImpl;

    public EmployeeController(ServiceEmployeeImpl serviceEmployeeImpl) {
        this.serviceEmployeeImpl = serviceEmployeeImpl;
    }

    //Endpoint : GetAll
    @GetMapping
    public List<Employee> getAll() {
        return serviceEmployeeImpl.getAll();
    }

    //Endpoint : Post or Save Operation
    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return serviceEmployeeImpl.create(employee);
    }
}
