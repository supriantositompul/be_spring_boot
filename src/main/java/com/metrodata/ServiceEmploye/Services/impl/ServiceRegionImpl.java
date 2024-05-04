package com.metrodata.ServiceEmploye.Services.impl;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.metrodata.ServiceEmploye.Services.GenericServices;
import lombok.AllArgsConstructor;
import com.metrodata.ServiceEmploye.Models.Entity.Region;
import com.metrodata.ServiceEmploye.Repositories.RegionRepository;

@Service
@AllArgsConstructor
public class ServiceRegionImpl implements GenericServices<Region, Integer> {
    private RegionRepository regionRepository;

    @Override
    public List<Region> getAll() {
        return regionRepository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Region getById(Integer id) {
        return regionRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Region not found!!!"));
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
    public Region update(Integer id, Region region) {
        getById(id);
        region.setId(id);
        return regionRepository.save(region);
    }

    @SuppressWarnings("null")
    @Override
    public Region delete(Integer id) {
        Region region = getById(id);
        regionRepository.delete(region);
        return region;
    }

    public List<Region> searchNameByNative(String name) {
        return regionRepository.searchNameByNative("%" + name + "%");
    }

    public List<Region> searchNameByJPQL(String name) {
        return regionRepository.searchNameByJPQL("%" + name + "%");
    }
}


