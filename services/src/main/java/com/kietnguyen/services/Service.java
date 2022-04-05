package com.kietnguyen.services;

import com.kietnguyen.services.tools.ServiceException;

import java.util.List;

public interface Service<T> {
    public boolean add(T t) throws ServiceException;

    public List<T> getAll() throws ServiceException;

    public boolean delete(Integer id) throws ServiceException;

    public T get(Integer id) throws ServiceException;

    public boolean update(T t) throws ServiceException;
}
