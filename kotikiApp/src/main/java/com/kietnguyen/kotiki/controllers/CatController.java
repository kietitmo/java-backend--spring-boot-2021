package com.kietnguyen.kotiki.controllers;

import com.kietnguyen.models.Cat;
import com.kietnguyen.models.CatAndFriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.kietnguyen.services.CatService;
import com.kietnguyen.services.tools.ServiceException;

import java.util.List;

@RestController
@RequestMapping("/cat")
public class CatController {
    @Autowired
    CatService catService;

    @PostMapping(value = "/add")
    public @ResponseBody Cat add(@RequestBody Cat cat) throws ServiceException {
        catService.add(cat);
        return cat;
    }

    @GetMapping(value = "/get/{id}")
    public @ResponseBody Cat get(@PathVariable("id") Integer id) throws ServiceException {
        return catService.get(id);
    }

    @GetMapping(value = "/getAll")
    public List<Cat> getAll() throws ServiceException {
        return catService.getAll();
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteCat(@PathVariable Integer id) throws ServiceException {
        catService.delete(id);
        return "Deleted";
    }

    @GetMapping(value = "/getAllFriend/{id}")
    public List<Cat> getAllFriend(@PathVariable Integer id) throws ServiceException {
        return catService.getFriendListOfCat(id);
    }

    @GetMapping(value = "/getCatsOfOwner/{ownerId}")
    public List<Cat> getAllCatsOfOwner(@PathVariable Integer ownerId) throws ServiceException {
        return catService.getAllCatsOfOwner(ownerId);
    }

    @PostMapping(value = "/addCatAndFriend/{id}/{idFriend}")
    public @ResponseBody CatAndFriend addCatAndFriend(@PathVariable Integer id, @PathVariable Integer idFriend) throws ServiceException {
        CatAndFriend catAndFriend = new CatAndFriend(catService.get(id), catService.get(idFriend));
        catService.addCatAndFriend(catAndFriend);
        return catAndFriend;
    }

    @DeleteMapping(value = "/deleteAllFriendOfCat/{id}")
    public void deleteAllFriendsOfCat(@PathVariable Integer id) throws ServiceException {
        catService.deleteAllFriendOfCat(id);
    }

    @DeleteMapping(value = "/deleteFriendOfCat/{id}/{idFriend}")
    public void deleteFriendOfCat(@PathVariable Integer id, @PathVariable Integer idFriend) throws ServiceException {
        catService.deleteFriendOfCat(id,idFriend);
    }

    @GetMapping(value = "/getCAF/{id}")
    public @ResponseBody CatAndFriend getCAF(@PathVariable("id") Integer id) throws ServiceException {
        return catService.getCAF(id);
    }
}
