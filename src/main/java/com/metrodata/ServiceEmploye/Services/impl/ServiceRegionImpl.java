package com.metrodata.ServiceEmploye.Services.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.metrodata.ServiceEmploye.Services.GenericServices;
import com.metrodata.ServiceEmploye.Models.Entity.Region;
import com.metrodata.ServiceEmploye.Repositories.RegionRepository;

@Service
public class ServiceRegionImpl implements GenericServices<Region> {
    private RegionRepository regionRepository;

    public ServiceRegionImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> getAll() {
        return regionRepository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Region getById(Integer id) {
        return regionRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "region not found"));

    }

    @Override
    public Region create(Region region) {
        if (regionRepository.findByName(region.getName()).isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Name is already exists!");
        }
        return regionRepository.save(region);
    }


    @Override
    public Region delete(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Region update(Integer id, Region Entity) {
        // TODO Auto-generated method stub
        return null;
    }
}


