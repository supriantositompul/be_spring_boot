package com.metrodata.ServiceEmploye.Controllers.impl;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metrodata.ServiceEmploye.Controllers.GenericController;
import com.metrodata.ServiceEmploye.Models.Entity.Role;
import com.metrodata.ServiceEmploye.Services.impl.ServiceRoleImpl;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/role")
public class RoleControllerImpl implements GenericController<Role, Integer> {
    private ServiceRoleImpl serviceRoleImpl;

    @Override
    @GetMapping
    public List<Role> getAll() {
        return serviceRoleImpl.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public Role getById(@PathVariable Integer id) {
        return serviceRoleImpl.getById(id);
    }

    @Override
    @PostMapping
    public Role create(@RequestBody Role role) {
        return serviceRoleImpl.create(role);
    }

    @Override
    @PutMapping("/{id}")
    public Role update(@PathVariable Integer id, @RequestBody Role role) {
        return serviceRoleImpl.update(id, role);
    }

    @Override
    @DeleteMapping("/{id}")
    public Role delete(@PathVariable Integer id) {
        return serviceRoleImpl.delete(id);
    }
}
