package com.metrodata.ServiceEmploye.Services;


// public interface AuthServices {
//     Employee registration(RegistrationRequest registrationRequest);
//     LoginResponse login(LoginRequest loginRequest);
// }


public interface AuthServices<T, REQ> {
    T registration(REQ request);
}