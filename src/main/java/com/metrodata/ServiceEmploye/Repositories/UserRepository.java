package com.metrodata.ServiceEmploye.Repositories;

import java.util.Optional;
import com.metrodata.ServiceEmploye.Models.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByUsernameOrEmployee_Email(String username, String email);
}