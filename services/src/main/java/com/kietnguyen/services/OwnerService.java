package com.kietnguyen.services;

import com.kietnguyen.services.tools.ServiceException;
import com.kietnguyen.models.Owner;

import java.util.List;

public interface OwnerService extends Service<Owner>{
    public boolean add(Owner owner) throws ServiceException;
    public List<Owner> getAll() throws ServiceException;
    public boolean delete(Integer ownerId) throws ServiceException;
    public Owner get(Integer ownerId) throws ServiceException;
    public boolean update(Owner owner) throws ServiceException;
}
