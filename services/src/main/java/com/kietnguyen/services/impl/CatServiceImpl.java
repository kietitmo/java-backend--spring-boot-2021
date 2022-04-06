package com.kietnguyen.services.impl;

import com.kietnguyen.models.CatAndFriend;
import com.kietnguyen.services.CatService;
import com.kietnguyen.services.tools.ServiceException;
import com.kietnguyen.models.Cat;
import com.kietnguyen.repositories.CatAndFriendRepository;
import com.kietnguyen.repositories.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<Cat> getAllCatsOfOwner(Integer ownerId) throws ServiceException {
        try {
            return catRepository.getAllCatsOfOwner(ownerId);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Cat> getFriendListOfCat(Integer id) throws ServiceException {
        try {
            return catAndFriendRepository.getFriendListOfCat(id);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean deleteFriendOfCat(Integer id, Integer idFriend) throws ServiceException {
        try {
            catAndFriendRepository.deleteFriendOfCat(id,idFriend);
            return true;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean deleteAllFriendOfCat(Integer id) throws ServiceException {
        try {
            catAndFriendRepository.deleteAllFriendOfCat(id);
            return true;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean addCatAndFriend(CatAndFriend catAndFriend) throws ServiceException {
        try {
            catAndFriendRepository.save(catAndFriend);
            catAndFriendRepository.save(new CatAndFriend(catRepository.getById(catAndFriend.getFriend().getId()), catRepository.getById(catAndFriend.getCat().getId())));
            return true;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public CatAndFriend getCAF(Integer catId) throws ServiceException {
        try {
            return catAndFriendRepository.getById(catId);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }
}