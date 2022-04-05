package com.kietnguyen.kotiki.controllers;

import com.kietnguyen.models.Cat;
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

    @GetMapping(value = "/test")
    public String test(){
        return "Success";
    }

    @GetMapping(value = "/getAll")
    public List<Cat> getAll() throws ServiceException {
        return catService.getAll();
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable Integer id) throws ServiceException {
        catService.delete(id);
        return "Deleted";
    }
}
