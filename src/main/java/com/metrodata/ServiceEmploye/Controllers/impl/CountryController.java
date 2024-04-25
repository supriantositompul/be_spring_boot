package com.metrodata.ServiceEmploye.Controllers.impl;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metrodata.ServiceEmploye.Controllers.GenericController;
import com.metrodata.ServiceEmploye.Controllers.OptionalGenericController;
import com.metrodata.ServiceEmploye.Models.Entity.Country;
import com.metrodata.ServiceEmploye.Models.dto.Request.CountryRequest;
import com.metrodata.ServiceEmploye.Models.dto.Response.CountryResponse;
import com.metrodata.ServiceEmploye.Services.impl.ServiceCountryImpl;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/country")
public class CountryController
        implements
        GenericController<Country, Integer>,
        OptionalGenericController<Country, CountryRequest> {

    private ServiceCountryImpl countryServiceImpl;

    @Override
    @GetMapping
    public List<Country> getAll() {
        return countryServiceImpl.getAll();
    }

    @GetMapping("/custom-all")
    public List<Map<String, Object>> getAllCustom() {
        return countryServiceImpl.getAllCustom();
    }

    @Override
    @GetMapping("/{id}")
    public Country getById(@PathVariable Integer id) {
        return countryServiceImpl.getById(id);
    }

    @GetMapping("/custom/{id}")
    public CountryResponse getByIdCustom(@PathVariable Integer id) {
        return countryServiceImpl.getByIdCustom(id);
    }

    @GetMapping("/map/{id}")
    public Map<String, Object> getByIdMap(@PathVariable Integer id) {
        return countryServiceImpl.getByIdMap(id);
    }

    @Override
    @PostMapping
    public Country create(@RequestBody Country country) {
        return countryServiceImpl.create(country);
    }

    // Menggunakan DTO
    @PostMapping("/dto")
    public Country createDTO(@RequestBody CountryRequest countryRequest) {
        return countryServiceImpl.createDTO(countryRequest);
    }

    // Menggunakan Model Mapper
    @PostMapping("/dto-mm")
    public Country createModelMapper(@RequestBody CountryRequest countryRequest) {
        return countryServiceImpl.createModelMapper(countryRequest);
    }

    @Override
    @PostMapping("/custom")
    public Country createCustom(@RequestBody CountryRequest request) {
        return countryServiceImpl.createCustom(request);
    }

    @Override
    @PutMapping("/{id}")
    public Country update(
            @PathVariable Integer id,
            @RequestBody Country country) {
        return countryServiceImpl.update(id, country);
    }

    @Override
    @DeleteMapping("/{id}")
    public Country delete(@PathVariable Integer id) {
        return countryServiceImpl.delete(id);
    }
}