package com.metrodata.ServiceEmploye.Services.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.metrodata.ServiceEmploye.Models.Entity.Role;
import com.metrodata.ServiceEmploye.Repositories.RoleRepository;
import com.metrodata.ServiceEmploye.Services.GenericServices;
import java.util.List;

@Service
public class ServiceRoleImpl implements GenericServices<Role, Integer> {
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    @SuppressWarnings("null")
    public Role getById(Integer id) {
        return roleRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Role is not found!!!"));
    }

    @Override
    @SuppressWarnings("null")
    public Role create(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role update(Integer id, Role role) {
        getById(id);
        role.setId(id);
        return roleRepository.save(role);
    }

    @Override
    @SuppressWarnings("null")
    public Role delete(Integer id) {
        Role role = getById(id);
        roleRepository.delete(role);
        return role;
    }
}
