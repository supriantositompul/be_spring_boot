package com.metrodata.ServiceEmploye.Controllers;

public interface OptionalGenericController <T,REQ> {
    T createCustom(REQ request);

}
