package com.kietnguyen.services;

import com.kietnguyen.services.tools.ServicesException;

import java.util.List;

public interface Service<T> {
    boolean add(T t) throws ServicesException;

    List<T> getAll() throws ServicesException;

    boolean delete(Integer id) throws ServicesException;

    T get(Integer id) throws ServicesException;

    boolean update(T t) throws ServicesException;
}
