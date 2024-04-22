package com.metrodata.ServiceEmploye.Services;

import java.util.List;

public interface GenericServices <T> {
    List<T> getAll();

    T getById(Integer id);

    T create(T Entity);

    T update(Integer id, T Entity);

    T delete(Integer id);
}
