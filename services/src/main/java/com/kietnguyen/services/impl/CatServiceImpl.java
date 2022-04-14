package com.kietnguyen.services.impl;

import com.kietnguyen.enums.CatBreed;
import com.kietnguyen.enums.CatColor;
import com.kietnguyen.models.CatAndFriend;
import com.kietnguyen.services.CatService;
import com.kietnguyen.services.tools.ServicesException;
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
    public boolean add(Cat cat) throws ServicesException {
        try {
            catRepository.save(cat);
        } catch (Exception e) {
            throw new ServicesException(e.getMessage());
        }
        return true;
    }

    @Override
    public List<Cat> getAll() throws ServicesException {
        try {
            return catRepository.findAll();
        } catch (Exception e) {
            throw new ServicesException(e.getMessage());
        }
    }

    @Override
    public boolean delete(Integer catId) throws ServicesException {
        try {
            catRepository.deleteById(catId);
        } catch (Exception e) {
            throw new ServicesException(e.getMessage());
        }
        return true;
    }

    @Override
    public Cat get(Integer catId) throws ServicesException {
        try {
            return catRepository.getById(catId);
        } catch (Exception e) {
            throw new ServicesException(e.getMessage());
        }
    }

    @Override
    public boolean update(Cat cat) throws ServicesException {
        try {
            catRepository.save(cat);
            return true;
        } catch (Exception e) {
            throw new ServicesException(e.getMessage());
        }
    }

    @Override
    public List<Cat> getAllCatsOfOwner(Integer ownerId) throws ServicesException {
        try {
            return catRepository.getAllCatsOfOwner(ownerId);
        } catch (Exception e) {
            throw new ServicesException(e.getMessage());
        }
    }

    @Override
    public List<Cat> getFriendListOfCat(Integer id) throws ServicesException {
        try {
            return catAndFriendRepository.getFriendListOfCat(id);
        } catch (Exception e) {
            throw new ServicesException(e.getMessage());
        }
    }

    @Override
    public List<Cat> getCatByColor(CatColor color) throws ServicesException {
        try {
            return catRepository.getCatByColor(color);
        } catch (Exception e) {
            throw new ServicesException(e.getMessage());
        }
    }

    @Override
    public List<Cat> getCatByBreed(CatBreed breed) throws ServicesException {
        try {
            return catRepository.getCatByBreed(breed);
        } catch (Exception e) {
            throw new ServicesException(e.getMessage());
        }
    }

    @Override
    public boolean deleteFriendOfCat(Integer id, Integer idFriend) throws ServicesException {
        try {
            catAndFriendRepository.deleteFriendOfCat(id,idFriend);
        } catch (Exception e) {
            throw new ServicesException(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean deleteAllFriendOfCat(Integer id) throws ServicesException {
        try {
            catAndFriendRepository.deleteAllFriendOfCat(id);
        } catch (Exception e) {
            throw new ServicesException(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean addCatAndFriend(CatAndFriend catAndFriend) throws ServicesException {
        try {
            catAndFriendRepository.save(catAndFriend);
            catAndFriendRepository.save(new CatAndFriend(catRepository.getById(catAndFriend.getFriend().getId()), catRepository.getById(catAndFriend.getCat().getId())));
        } catch (Exception e) {
            throw new ServicesException(e.getMessage());
        }
        return true;
    }

    @Override
    public CatAndFriend getCAF(Integer catId) throws ServicesException {
        try {
            return catAndFriendRepository.getById(catId);
        } catch (Exception e) {
            throw new ServicesException(e.getMessage());
        }
    }
}