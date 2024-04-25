package com.metrodata.ServiceEmploye.Services;

public interface OptionalGenericService<T, REQ> {
    T createCustom(REQ request);
}
