package com.kietnguyen.services.impl;

import com.kietnguyen.models.AppRole;
import com.kietnguyen.repositories.AppRoleRepository;
import com.kietnguyen.services.AppRoleService;
import com.kietnguyen.services.tools.ServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppRoleServiceImpl implements AppRoleService {

    @Autowired
    private AppRoleRepository appRoleRepository;
    @Override
    public boolean add(AppRole appRole) throws ServicesException {
        try {
            appRoleRepository.save(appRole);
        } catch (Exception e) {
            throw new ServicesException(e.getMessage());
        }
        return true;
    }

    @Override
    public List<AppRole> getAll() throws ServicesException {
        try {
            return appRoleRepository.findAll();
        } catch (Exception e) {
            throw new ServicesException(e.getMessage());
        }
    }

    @Override
    public boolean delete(Integer id) throws ServicesException {
        try {
            appRoleRepository.deleteById(id);
        } catch (Exception e) {
            throw new ServicesException(e.getMessage());
        }
        return true;
    }

    @Override
    public AppRole get(Integer id) throws ServicesException {
        try {
            return appRoleRepository.getById(id);
        } catch (Exception e) {
            throw new ServicesException(e.getMessage());
        }
    }

    @Override
    public boolean update(AppRole appRole) throws ServicesException {
        try {
            appRoleRepository.save(appRole);
            return true;
        } catch (Exception e) {
            throw new ServicesException(e.getMessage());
        }
    }
}
