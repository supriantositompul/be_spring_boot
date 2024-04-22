package com.metrodata.ServiceEmploye.Controllers;

import java.util.List;

public interface GenericController <T> {
    List<T> getAll();
    
    T getById(Integer id);

    T create(T Entity);

    T update(Integer id, T Entity);

    T delete(T entity);

}
