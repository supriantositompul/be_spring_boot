package com.metrodata.ServiceEmploye.Controllers.impl;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.metrodata.ServiceEmploye.Models.Entity.Region;
import com.metrodata.ServiceEmploye.Services.impl.ServiceRegionImpl;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RestController
@RequestMapping("/region")
@PreAuthorize("hasAnyRole('USER', 'ADMIN_READ')")
public class RegionController {
    private ServiceRegionImpl serviceRegionImpl;

    public RegionController(ServiceRegionImpl serviceRegionImpl) {
        this.serviceRegionImpl = serviceRegionImpl;
    }

    //End point : GetAll
    @GetMapping
    @PreAuthorize("hasAnyAuthority('USER_READ', 'ADMIN_READ')")
    public List<Region> getAll() {
        return serviceRegionImpl.getAll();
    }

    // Save operation
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('USER_READ', 'ADMIN_READ')")
    public Region getById(@PathVariable Integer id) {
        return serviceRegionImpl.getById(id);
    }

    //Post
    @PostMapping
    @PreAuthorize("hasAnyAuthority('USER_CREATE', 'ADMIN_READ')")
    public Region create(@RequestBody Region region) {
        return serviceRegionImpl.create(region);
    }

    //Update
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('USER_UPDATE', 'ADMIN_READ')")
    public Region update(@PathVariable Integer id, @RequestBody Region region) {
        return serviceRegionImpl.update(id, region);
    }

    //Delete
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('USER_DELETE', 'ADMIN_READ')")
    public Region delete(@PathVariable Integer id) {
        return serviceRegionImpl.delete(id);
    }
}
