package com.kietnguyen.services.impl;

import com.kietnguyen.services.tools.ServiceException;
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
    public boolean add(Owner owner) throws ServiceException {
        try {
            ownerRepository.save(owner);
            return true;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Owner> getAll() throws ServiceException {
        List<Owner> ownerList;
        try {
            ownerList = ownerRepository.findAll();
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }

        return ownerList;
    }

    @Override
    public boolean delete(Integer ownerId) throws ServiceException {
        try {
            ownerRepository.deleteById(ownerId);
            return true;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Owner get(Integer ownerId) throws ServiceException {
        Owner owner;
        try {
            owner = ownerRepository.getById(ownerId);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }

        return owner;
    }

    @Override
    public boolean update(Owner owner) throws ServiceException {
        try {
            ownerRepository.save(owner);
            return true;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

}
