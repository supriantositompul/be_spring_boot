package com.metrodata.ServiceEmploye.Controllers.impl;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metrodata.ServiceEmploye.Controllers.GenericController;
import com.metrodata.ServiceEmploye.Models.Entity.Employee;
import com.metrodata.ServiceEmploye.Services.impl.ServiceEmployeeImpl;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController implements GenericController<Employee, Integer> {
    private ServiceEmployeeImpl serviceEmployeeImpl;

    @Override
    @GetMapping
    public List<Employee> getAll() {
        return serviceEmployeeImpl.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public Employee getById(@PathVariable Integer id) {
        return serviceEmployeeImpl.getById(id);
    }
    @Override
    public Employee create(@RequestBody Employee employee) {
        return null;
    }

    @Override
    @PutMapping("/{id}")
    public Employee update(
            @PathVariable Integer id,
            @RequestBody Employee employee) {
        return serviceEmployeeImpl.update(id, employee);
    }

    @Override
    @DeleteMapping("/{id}")
    public Employee delete(@PathVariable Integer id) {
        return serviceEmployeeImpl.delete(id);
    }


}
