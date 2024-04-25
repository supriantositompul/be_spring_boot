package com.metrodata.ServiceEmploye.Models.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CountryResponse {
    private Integer countryId;
    private String countryCode;
    private String countryName;
    private Integer regionId;
    private String regionName;
}