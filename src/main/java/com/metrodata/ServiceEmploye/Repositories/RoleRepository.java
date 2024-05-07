package com.metrodata.ServiceEmploye.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.metrodata.ServiceEmploye.Models.Entity.Role;


public interface RoleRepository extends JpaRepository<Role, Integer> {

}
