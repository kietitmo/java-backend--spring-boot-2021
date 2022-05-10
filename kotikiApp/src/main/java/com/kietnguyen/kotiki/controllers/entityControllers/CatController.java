package com.kietnguyen.kotiki.controllers.entityControllers;

import com.kietnguyen.enums.CatBreed;
import com.kietnguyen.enums.CatColor;
import com.kietnguyen.models.Cat;
import com.kietnguyen.models.CatAndFriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.kietnguyen.services.CatService;
import com.kietnguyen.services.tools.ServicesException;

import java.util.List;

@RestController
@RequestMapping("/cat")
public class CatController {
    @Autowired
    CatService catService;

    @PostMapping(value = "/add",produces = "application/json")
    public @ResponseBody Cat add(@RequestBody Cat cat) throws ServicesException {
        catService.add(cat);
        return cat;
    }

    @GetMapping(value = "/get/{id}")
    public @ResponseBody Cat get(@PathVariable("id") Integer id) throws ServicesException {
        return catService.get(id);
    }

    @PutMapping(value = "/update/{id}")
    public boolean update(@PathVariable("id") Integer id, @RequestBody Cat cat) throws ServicesException {
        Cat catGot = catService.get(id);
        catGot.clone(cat);
        return catService.update(catGot);
    }

    @GetMapping(value = "/getByColor")
    public List<Cat> getByColor(@RequestParam(value = "color") String color) throws ServicesException {
        return catService.getCatByColor(CatColor.valueOf(color.toUpperCase()));
    }

    @GetMapping(value = "/getByBreed")
    public List<Cat> getByBreed(@RequestParam(value = "breed") String breed) throws ServicesException {
        return catService.getCatByBreed(CatBreed.valueOf(breed.toUpperCase()));
    }

    @GetMapping(value = "/getAll")
    public List<Cat> getAll() throws ServicesException {
        return catService.getAll();
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteCat(@PathVariable Integer id) throws ServicesException {
        catService.delete(id);
        return "Deleted";
    }

    @GetMapping(value = "/getAllFriend/{id}")
    public List<Cat> getAllFriend(@PathVariable Integer id) throws ServicesException {
        return catService.getFriendListOfCat(id);
    }

    @GetMapping(value = "/getCatsOfOwner/{ownerId}")
    public List<Cat> getAllCatsOfOwner(@PathVariable Integer ownerId) throws ServicesException {
        return catService.getAllCatsOfOwner(ownerId);
    }

    @PostMapping(value = "/addCatAndFriend/{id}/{idFriend}")
    public @ResponseBody CatAndFriend addCatAndFriend(@PathVariable Integer id, @PathVariable Integer idFriend) throws ServicesException {
        CatAndFriend catAndFriend = new CatAndFriend(catService.get(id), catService.get(idFriend));
        catService.addCatAndFriend(catAndFriend);
        return catAndFriend;
    }

    @DeleteMapping(value = "/deleteAllFriendOfCat/{id}")
    public void deleteAllFriendsOfCat(@PathVariable Integer id) throws ServicesException {
        catService.deleteAllFriendOfCat(id);
    }

    @DeleteMapping(value = "/deleteFriendOfCat/{id}/{idFriend}")
    public void deleteFriendOfCat(@PathVariable Integer id, @PathVariable Integer idFriend) throws ServicesException {
        catService.deleteFriendOfCat(id,idFriend);
    }

    @GetMapping(value = "/getCAF/{id}")
    public @ResponseBody CatAndFriend getCAF(@PathVariable("id") Integer id) throws ServicesException {
        return catService.getCAF(id);
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute("cat") Cat cat) throws ServicesException {
        catService.add(cat);

        return "redirect:/";
    }
}
