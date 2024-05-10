package com.metrodata.ServiceEmploye.Services;

import com.metrodata.ServiceEmploye.Models.Entity.Employee;
import com.metrodata.ServiceEmploye.Models.dto.Request.LoginRequest;
import com.metrodata.ServiceEmploye.Models.dto.Request.RegistrationRequest;
import com.metrodata.ServiceEmploye.Models.dto.Response.LoginResponse;

public interface AuthServices {
    Employee registration(RegistrationRequest registrationRequest);
    LoginResponse login(LoginRequest loginRequest);
}


// public interface AuthServices<T, REQ> {
//     T registration(REQ request);
// }



    // private EmployeeRepository employeeRepository;
    // private ModelMapper modelMapper;
    // private EmployeeServiceImpl employeeServiceImpl;
    // private RoleServiceImpl roleServiceImpl;
    // private UserRepository userRepository;
    // private PasswordEncoder passwordEncoder;
    // private AuthenticationManager authenticationManager;
    // private AppUserDetailService appUserDetailService;
