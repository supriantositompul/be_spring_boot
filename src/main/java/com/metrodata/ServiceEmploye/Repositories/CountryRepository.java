package com.metrodata.ServiceEmploye.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metrodata.ServiceEmploye.Models.Entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
    boolean existsByName(String name);
}
