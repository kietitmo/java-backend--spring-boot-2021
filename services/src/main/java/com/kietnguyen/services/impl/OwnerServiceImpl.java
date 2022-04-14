package com.kietnguyen.services.impl;

import com.kietnguyen.services.tools.ServicesException;
import com.kietnguyen.models.Owner;
import com.kietnguyen.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kietnguyen.services.OwnerService;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public boolean add(Owner owner) throws ServicesException {
        try {
            ownerRepository.save(owner);
        } catch (Exception e) {
            throw new ServicesException(e.getMessage());
        }
        return true;
    }

    @Override
    public List<Owner> getAll() throws ServicesException {
        try {
            return ownerRepository.findAll();
        } catch (Exception e) {
            throw new ServicesException(e.getMessage());
        }
    }

    @Override
    public boolean delete(Integer ownerId) throws ServicesException {
        try {
            ownerRepository.deleteById(ownerId);
        } catch (Exception e) {
            throw new ServicesException(e.getMessage());
        }
        return true;
    }

    @Override
    public Owner get(Integer ownerId) throws ServicesException {
        Owner owner;
        try {
            owner = ownerRepository.getById(ownerId);
        } catch (Exception e) {
            throw new ServicesException(e.getMessage());
        }

        return owner;
    }

    @Override
    public boolean update(Owner owner) throws ServicesException {
        try {
            ownerRepository.save(owner);
            return true;
        } catch (Exception e) {
            throw new ServicesException(e.getMessage());
        }
    }

}
