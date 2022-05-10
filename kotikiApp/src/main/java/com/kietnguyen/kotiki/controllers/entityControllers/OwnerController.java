package com.kietnguyen.kotiki.controllers.entityControllers;

import com.kietnguyen.models.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.kietnguyen.services.OwnerService;
import com.kietnguyen.services.tools.ServicesException;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    OwnerService ownerService;

    @PostMapping(value = "/add")
    public void add(@RequestBody Owner owner) throws ServicesException {
        ownerService.add(owner);
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute("owner") Owner owner) throws ServicesException {
        ownerService.add(owner);

        return "redirect:/";
    }

    @GetMapping(value = "/get/{id}")
    public Owner get(@PathVariable("id") Integer id) throws ServicesException {
        return ownerService.get(id);
    }

    @GetMapping(value = "/getAll")
    public List<Owner> getAll() throws ServicesException {
        return ownerService.getAll();
    }

    @PutMapping(value = "/update/{id}")
    public boolean update(@PathVariable("id") Integer id, @RequestBody Owner owner) throws ServicesException {
        Owner ownerGot = ownerService.get(id);
        ownerGot.clone(owner);
        return ownerService.update(ownerGot);
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable Integer id) throws ServicesException {
        ownerService.delete(id);
        return "redirect:/";
    }
}
