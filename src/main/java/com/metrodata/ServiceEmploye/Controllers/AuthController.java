package com.metrodata.ServiceEmploye.Controllers;


public interface AuthController <T, REQ> {

    T registration(REQ request);
}
