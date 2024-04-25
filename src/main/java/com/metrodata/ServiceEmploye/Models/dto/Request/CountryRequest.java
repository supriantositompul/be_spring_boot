package com.metrodata.ServiceEmploye.Models.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryRequest {

    @NotBlank(message = "Country Code Cannot Blank")
    @NotNull(message = "Country Code Cannot Null")
    @Size(min = 2, max = 2, message = "Country Code Must Contains 2 Characters")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Country Code can only contain letters")
    private String code;

    @NotBlank(message = "Country Name Cannot Blank")
    @NotNull(message = "Country Name Cannot Blank")
    @Size(min = 1, max = 40, message = "Country Name Must Contains (1 - 40) Characters")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Country Name can only contain letters and spaces")
    private String name;

    @NotNull(message = "Region Id Cannot Null")
    @Min(value = 1, message = "Invalid ID Region")
    private Integer regionId;
}
