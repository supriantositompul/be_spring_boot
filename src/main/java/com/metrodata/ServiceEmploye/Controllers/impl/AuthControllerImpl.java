package com.metrodata.ServiceEmploye.Controllers.impl;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metrodata.ServiceEmploye.Controllers.AuthController;
import com.metrodata.ServiceEmploye.Models.Entity.Employee;
import com.metrodata.ServiceEmploye.Models.Entity.Role;
import com.metrodata.ServiceEmploye.Models.dto.Request.RegistrationRequest;
import com.metrodata.ServiceEmploye.Services.impl.AuthServicesImpl;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthControllerImpl implements AuthController<Employee, RegistrationRequest> {
    private AuthServicesImpl authServicesImpl;

    @Override
    @PostMapping("add-role/registration")
    public Employee registration(@RequestBody RegistrationRequest request) {
        return authServicesImpl.registration(request);
    }

    @PutMapping("/{idEmployee}")
    public Employee addRole(@PathVariable Integer idEmployee, @RequestBody Role role) {
        return authServicesImpl.addRole(idEmployee, role);
    }
}
