package com.metrodata.ServiceEmploye.Services.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.metrodata.ServiceEmploye.Models.Entity.Employee;
import com.metrodata.ServiceEmploye.Repositories.EmployeeRepository;
import com.metrodata.ServiceEmploye.Services.GenericServices;

import lombok.AllArgsConstructor;
import java.util.List;

@Service
@AllArgsConstructor
public class ServiceEmployeeImpl implements GenericServices<Employee, Integer> {

    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    @SuppressWarnings("null")
    public Employee getById(Integer id) {
        return employeeRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Employee is not found!"));
    }

    @Override
    @SuppressWarnings("null")
    public Employee create(Employee role) {
        return null;
    }

    // @Override
    // @SuppressWarnings("null")
    // public Employee create(Employee role) {
    //     return employeeRepository.save(role);
    //     }

    @Override
    public Employee update(Integer id, Employee employee) {
        getById(id);
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    @Override
    @SuppressWarnings("null")
    public Employee delete(Integer id) {
        Employee employee = getById(id);
        employeeRepository.delete(employee);
        return employee;
    }

}
