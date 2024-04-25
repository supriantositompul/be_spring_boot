package com.metrodata.ServiceEmploye.Services;

import java.util.List;

public interface GenericServices <T, ID> {
    List<T> getAll();

    T getById(ID id);

    T create(T Entity);

    T update(ID id, T Entity);

    T delete(ID id);
}
