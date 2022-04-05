package com.kietnguyen.services.impl;

import com.kietnguyen.services.CatService;
import com.kietnguyen.services.tools.ServiceException;
import com.kietnguyen.models.Cat;
import com.kietnguyen.repositories.CatAndFriendRepository;
import com.kietnguyen.repositories.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatServiceImpl implements CatService {
    @Autowired
    private CatRepository catRepository;
    @Autowired
    private CatAndFriendRepository catAndFriendRepository;

    @Override
    public boolean add(Cat cat) throws ServiceException {
        try {
            catRepository.save(cat);
            return true;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Cat> getAll() throws ServiceException {
        try {
            return catRepository.findAll();
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean delete(Integer catId) throws ServiceException {
        try {
            catRepository.deleteById(catId);
            return true;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Cat get(Integer catId) throws ServiceException {
        try {
            return catRepository.getById(catId);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean update(Cat cat) throws ServiceException {
        try {
            catRepository.save(cat);
            return true;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Cat> getAllCatsOfOwner(Integer ownerId) {
        return catRepository.getAllCatsOfOwner(ownerId);
    }

    @Override
    public List<Cat> getFriendListOfCat(Integer id) {
        return catAndFriendRepository.getFriendListOfCat(id);
    }

    @Override
    public boolean deleteFriendOfCat(Integer id, Integer idFriend) {
        return catAndFriendRepository.deleteFriendOfCat(id,idFriend);
    }

    @Override
    public boolean deleteAllFriendOfCat(Integer id) {
        return catAndFriendRepository.deleteAllFriendOfCat(id);
    }
}