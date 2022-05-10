package com.kietnguyen.services.impl;

import com.kietnguyen.models.AppUser;
import com.kietnguyen.repositories.AppUserRepository;
import com.kietnguyen.services.UserService;
import com.kietnguyen.services.tools.ServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private AppUserRepository appUserRepository;

    public boolean add(AppUser user) throws ServicesException {
        try {
            appUserRepository.save(user);
        } catch (Exception e) {
            throw new ServicesException(e.getMessage());
        }
        return true;
    }

    public AppUser get(Integer id) throws ServicesException {
        try {
            return appUserRepository.getById(id);
        } catch (Exception e) {
            throw new ServicesException(e.getMessage());
        }
    }

    public AppUser getByUsername(String username) throws ServicesException {
        try {
            return appUserRepository.findUserAccount(username);
        } catch (Exception e) {
            throw new ServicesException(e.getMessage());
        }
    }

    public boolean delete(Integer id) throws ServicesException {
        try {
            appUserRepository.deleteById(id);
        } catch (Exception e) {
            throw new ServicesException(e.getMessage());
        }
        return true;
    }

    public boolean update(AppUser user) throws ServicesException {
        try {
            appUserRepository.save(user);
            return true;
        } catch (Exception e) {
            throw new ServicesException(e.getMessage());
        }
    }

    public List<AppUser> getAll() throws ServicesException {
        try {
            return appUserRepository.findAll();
        } catch (Exception e) {
            throw new ServicesException(e.getMessage());
        }
    }
}
