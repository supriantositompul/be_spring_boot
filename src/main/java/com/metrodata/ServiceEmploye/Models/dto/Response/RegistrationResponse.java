package com.metrodata.ServiceEmploye.Models.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationResponse {
    private String name;
    private String email;
    private String phone;
    private String username;
    private String password;
    private List<String> authorities;
}
