package com.metrodata.ServiceEmploye.Services.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.springframework.web.server.ResponseStatusException;

import com.metrodata.ServiceEmploye.Repositories.EmployeeRepository;
import com.metrodata.ServiceEmploye.Services.GenericServices;
import com.metrodata.ServiceEmploye.Models.Entity.Employee;
import java.util.List;


@Service
public class ServiceEmployeeImpl implements GenericServices<Employee> {
    private EmployeeRepository employeeRepository;

    public ServiceEmployeeImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee create(Employee employee) {
        if (employeeRepository.findByName(employee.getName()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Name is already exists!");
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employee delete(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Employee getById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Employee update(Integer id, Employee Entity) {
        // TODO Auto-generated method stub
        return null;
    }

}
