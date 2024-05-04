package com.metrodata.ServiceEmploye.Models.dto.Request;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {
    private String name;
    private String email;
    private String phone;
    private String username;
    private String password;

}
