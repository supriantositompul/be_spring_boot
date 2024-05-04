package com.metrodata.ServiceEmploye.Models.dto.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    @NotBlank(message =  "Username cannot blank")
    private String username;

    @NotBlank(message = "Password cannnot blank")
    @Size(min = 8, message = "Password lenght must be at least 8 characters" )
    private String password;
}
    