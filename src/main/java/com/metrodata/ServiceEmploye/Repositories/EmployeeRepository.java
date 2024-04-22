package com.metrodata.ServiceEmploye.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.metrodata.ServiceEmploye.Models.Entity.Employee;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByName(String name);
}
