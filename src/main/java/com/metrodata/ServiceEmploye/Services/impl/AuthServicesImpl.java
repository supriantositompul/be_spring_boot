package com.metrodata.ServiceEmploye.Services.impl;

import com.metrodata.ServiceEmploye.Models.Entity.Employee;
import com.metrodata.ServiceEmploye.Models.Entity.Role;
import com.metrodata.ServiceEmploye.Models.Entity.User;
import com.metrodata.ServiceEmploye.Models.dto.Request.LoginRequest;
import com.metrodata.ServiceEmploye.Models.dto.Request.RegistrationRequest;
import com.metrodata.ServiceEmploye.Models.dto.Response.LoginResponse;
import com.metrodata.ServiceEmploye.Repositories.EmployeeRepository;
import com.metrodata.ServiceEmploye.Repositories.UserRepository;
import com.metrodata.ServiceEmploye.Services.AuthServices;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServicesImpl implements AuthServices {
    private ModelMapper modelMapper;
    private EmployeeRepository employeeRepository;
    private ServiceEmployeeImpl serviceEmployeeImpl;
    private ServiceRoleImpl serviceRoleImpl;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private AppUserDetailService appUserDetailService;


    @Override
    public Employee registration(RegistrationRequest registrationRequest) {
        Employee employee = modelMapper.map(registrationRequest, Employee.class);
        User user = modelMapper.map(registrationRequest, User.class);
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        List<Role> roles = Collections.singletonList(serviceRoleImpl.getById(3));
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

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword());
        Authentication auth = authenticationManager.authenticate(authReq);
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(auth);
        UserDetails userDetails = appUserDetailService.loadUserByUsername(
                loginRequest.getUsername());
        User user = userRepository
                .findByUsernameOrEmployee_Email(
                        loginRequest.getUsername(),
                        loginRequest.getUsername())
                .get();

        List<String> authorities = userDetails
                .getAuthorities()
                .stream()
                .map(authority -> authority.getAuthority())
                .collect(Collectors.toList());

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUsername(userDetails.getUsername());
        loginResponse.setEmail(user.getEmployee().getEmail());
        loginResponse.setAuthorities(authorities);

        return loginResponse;
    }
}
