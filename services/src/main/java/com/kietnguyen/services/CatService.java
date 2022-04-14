package com.kietnguyen.services;

import com.kietnguyen.enums.CatBreed;
import com.kietnguyen.enums.CatColor;
import com.kietnguyen.models.CatAndFriend;
import com.kietnguyen.services.tools.ServicesException;
import com.kietnguyen.models.Cat;

import java.util.List;

public interface CatService extends Service<Cat>{
    List<Cat> getAllCatsOfOwner(Integer ownerId) throws ServicesException;
    List<Cat> getFriendListOfCat(Integer id) throws ServicesException;
    List<Cat> getCatByColor(CatColor color) throws ServicesException;
    List<Cat> getCatByBreed(CatBreed breed) throws ServicesException;
    boolean deleteFriendOfCat(Integer id, Integer idFriend) throws ServicesException;
    boolean deleteAllFriendOfCat(Integer id) throws ServicesException;
    boolean addCatAndFriend(CatAndFriend catAndFriend) throws ServicesException;
    CatAndFriend getCAF(Integer catId) throws ServicesException;
}
