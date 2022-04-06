package com.kietnguyen.kotiki.controllers;

import com.kietnguyen.models.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.kietnguyen.services.OwnerService;
import com.kietnguyen.services.tools.ServiceException;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    OwnerService ownerService;

    @PostMapping(value = "/add")
    public void add(@RequestBody Owner owner) throws ServiceException {
        ownerService.add(owner);
    }

    @GetMapping(value = "/get/{id}")
    public Owner get(@PathVariable("id") Integer id) throws ServiceException {
        return ownerService.get(id);
    }

    @GetMapping(value = "/getAll")
    public List<Owner> getAll() throws ServiceException {
        return ownerService.getAll();
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable Integer id) throws ServiceException {
        ownerService.delete(id);
        return "deleted";
    }
}
