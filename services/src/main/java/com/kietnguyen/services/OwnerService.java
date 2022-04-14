package com.kietnguyen.services;

import com.kietnguyen.services.tools.ServicesException;
import com.kietnguyen.models.Owner;

import java.util.List;

public interface OwnerService extends Service<Owner>{
    boolean add(Owner owner) throws ServicesException;
    List<Owner> getAll() throws ServicesException;
    boolean delete(Integer ownerId) throws ServicesException;
    Owner get(Integer ownerId) throws ServicesException;
    boolean update(Owner owner) throws ServicesException;
}
