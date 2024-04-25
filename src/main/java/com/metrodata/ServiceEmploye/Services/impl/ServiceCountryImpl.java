package com.metrodata.ServiceEmploye.Services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.metrodata.ServiceEmploye.Models.Entity.Country;
import com.metrodata.ServiceEmploye.Models.dto.Request.CountryRequest;
import com.metrodata.ServiceEmploye.Models.dto.Response.CountryResponse;
import com.metrodata.ServiceEmploye.Repositories.CountryRepository;
import com.metrodata.ServiceEmploye.Services.GenericServices;
import com.metrodata.ServiceEmploye.Services.OptionalGenericService;
import com.metrodata.ServiceEmploye.Models.Entity.Region;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceCountryImpl
        implements
        GenericServices<Country, Integer>,
        OptionalGenericService<Country, CountryRequest> {

    private CountryRepository countryRepository;
    private ServiceRegionImpl regionServiceImpl;
    private ModelMapper modelMapper;

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    // custom List of Map => getAll
    public List<Map<String, Object>> getAllCustom() {
        return countryRepository
                .findAll()
                .stream()
                .map(country -> {
                    Map<String, Object> result = new HashMap<>();
                    result.put("countryId", country.getId());
                    result.put("countryCode", country.getCode());
                    result.put("countryName", country.getName());
                    result.put("regionId", country.getRegion().getId());
                    result.put("regionName", country.getRegion().getName());
                    return result;
                })
                .collect(Collectors.toList());
    }

    @SuppressWarnings("null")
    @Override
    public Country getById(Integer id) {
        return countryRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Country not found!!!"));
    }

    // custom response
    @SuppressWarnings("null")
    public CountryResponse getByIdCustom(Integer id) {
        Country country = countryRepository.findById(id).get();

        CountryResponse countryResponse = new CountryResponse();
        countryResponse.setCountryId(country.getId());
        countryResponse.setCountryCode(country.getCode());
        countryResponse.setCountryName(country.getName());
        countryResponse.setRegionId(country.getRegion().getId());
        countryResponse.setRegionName(country.getRegion().getName());
        return countryResponse;
    }

    // custom original object response
    @SuppressWarnings("null")
    public Map<String, Object> getByIdMap(Integer id) {
        Map<String, Object> result = new HashMap<>();
        Country country = countryRepository.findById(id).get();

        result.put("countryId", country.getId());
        result.put("countryCode", country.getCode());
        result.put("countryName", country.getName());
        result.put("regionId", country.getRegion().getId());
        result.put("regionName", country.getRegion().getName());

        return result;
    }

    // without dto
    @SuppressWarnings("null")
    @Override
    public Country create(Country country) {
        return countryRepository.save(country);
    }

    // with dto
    public Country createDTO(CountryRequest countryRequest) {
        Country country = new Country();
        country.setCode(countryRequest.getCode());
        country.setName(countryRequest.getName());

        Region region = regionServiceImpl.getById(countryRequest.getRegionId());
        country.setRegion(region);

        return countryRepository.save(country);
    }

    // with dto by modelmapper
    public Country createModelMapper(CountryRequest countryRequest) {
        Country country = modelMapper.map(countryRequest, Country.class);
        country.setRegion(regionServiceImpl.getById(countryRequest.getRegionId()));
        return countryRepository.save(country);
    }

    // custom request
    @Override
    public Country createCustom(CountryRequest request) {
        if (countryRepository.existsByName(request.getName())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Name is already exists!!!");
        }

        Country country = modelMapper.map(request, Country.class);
        country.setRegion(regionServiceImpl.getById(request.getRegionId()));
        return countryRepository.save(country);
    }

    @Override
    public Country update(Integer id, Country country) {
        getById(id);
        country.setId(id);
        return countryRepository.save(country);
    }

    @SuppressWarnings("null")
    @Override
    public Country delete(Integer id) {
        Country country = getById(id);
        countryRepository.delete(country);
        return country;
    }
}