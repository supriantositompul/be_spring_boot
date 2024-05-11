package com.metrodata.ServiceEmploye.Controllers.impl;

//import org.springframework.security.access.prepost.PreAuthorize;
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
//@PreAuthorize("hasRole('USER')")
public class RegionController {
    private ServiceRegionImpl serviceRegionImpl;

    public RegionController(ServiceRegionImpl serviceRegionImpl) {
        this.serviceRegionImpl = serviceRegionImpl;
    }

    //End point : GetAll
    @GetMapping
    //@PreAuthorize("hasAuthority('USER_READ')")
    public List<Region> getAll() {
        return serviceRegionImpl.getAll();
    }

    // Save operation
    @GetMapping("/{id}")
    //@PreAuthorize("hasAuthority('USER_READ')")
    public Region getById(@PathVariable Integer id) {
        return serviceRegionImpl.getById(id);
    }

    //Post
    @PostMapping
    //@PreAuthorize("hasAuthority('USER_CREATE')")
    public Region create(@RequestBody Region region) {
        return serviceRegionImpl.create(region);
    }

    //Update
    @PutMapping("/{id}")
    //@PreAuthorize("hasAuthority('USER_UPDATE')")
    public Region update(@PathVariable Integer id, @RequestBody Region region) {
        return serviceRegionImpl.update(id, region);
    }

    //Delete
    @DeleteMapping("/{id}")
    //@PreAuthorize("hasAuthority('USER_DELETE')")
    public Region delete(@PathVariable Integer id) {
        return serviceRegionImpl.delete(id);
    }
}
