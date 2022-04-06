package com.kietnguyen.services;

import com.kietnguyen.models.CatAndFriend;
import com.kietnguyen.services.tools.ServiceException;
import com.kietnguyen.models.Cat;

import java.util.List;

public interface CatService extends Service<Cat>{
    public List<Cat> getAllCatsOfOwner(Integer ownerId) throws ServiceException;
    public List<Cat> getFriendListOfCat(Integer id) throws ServiceException;
    public boolean deleteFriendOfCat(Integer id, Integer idFriend) throws ServiceException;
    public boolean deleteAllFriendOfCat(Integer id) throws ServiceException;
    public boolean addCatAndFriend(CatAndFriend catAndFriend) throws ServiceException;
    public CatAndFriend getCAF(Integer catId) throws ServiceException;
}
