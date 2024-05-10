package com.metrodata.ServiceEmploye.Controllers;

import com.metrodata.ServiceEmploye.Models.Entity.Employee;
import com.metrodata.ServiceEmploye.Models.dto.Request.LoginRequest;
import com.metrodata.ServiceEmploye.Models.dto.Request.RegistrationRequest;
import com.metrodata.ServiceEmploye.Models.dto.Response.LoginResponse;

// public interface AuthController <T, REQ> {

//     T registration(REQ request);
// }


public interface AuthController {

    Employee registration(RegistrationRequest registrationRequest);
    LoginResponse login(LoginRequest loginRequest);
}