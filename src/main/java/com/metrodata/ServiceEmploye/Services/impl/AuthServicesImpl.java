package com.metrodata.ServiceEmploye.Services.impl;

import java.util.Collections;
//import java.util.Collections;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.metrodata.ServiceEmploye.Models.Entity.Employee;
import com.metrodata.ServiceEmploye.Models.Entity.Role;
import com.metrodata.ServiceEmploye.Models.Entity.User;
import com.metrodata.ServiceEmploye.Models.dto.Request.RegistrationRequest;
import com.metrodata.ServiceEmploye.Repositories.EmployeeRepository;
import com.metrodata.ServiceEmploye.Repositories.UserRepository;
import com.metrodata.ServiceEmploye.Services.AuthServices;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthServicesImpl implements AuthServices<Employee, RegistrationRequest> {
    private ModelMapper modelMapper;
    private EmployeeRepository employeeRepository;
    private ServiceEmployeeImpl serviceEmployeeImpl;
    private ServiceRoleImpl serviceRoleImpl;
    private UserRepository userRepository;

    // @Override
    // public Employee registration(RegistrationRequest request) {
    //     Employee employee = modelMapper.map(request, Employee.class);

    //     User user = new User();
    //     user.setUsername(request.getUsername());
    //     user.setPassword(request.getPassword());
    //     user.setEmployee(employee);
    //     employee.setUser(user);

    //     return employeeRepository.save(employee);
    // }


    @Override
    public Employee registration(RegistrationRequest registrationRequest) {
        Employee employee = modelMapper.map(registrationRequest, Employee.class);
        User user = modelMapper.map(registrationRequest, User.class);
        //user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        List<Role> roles = Collections.singletonList(serviceRoleImpl.getById(4));
        user.setRoles(roles);
        user.setEmployee(employee);
        employee.setUser(user);

        return employeeRepository.save(employee);
    }

    public Employee addRole(Integer idEmployee, Role role) {
        Employee employee = serviceEmployeeImpl.getById(idEmployee);
        User user = employee.getUser();
        List<Role> roles = user.getRoles();
        roles.add(serviceRoleImpl.getById(role.getId()));
        user.setRoles(roles);
        userRepository.save(user);
        return employee;
    }
}
