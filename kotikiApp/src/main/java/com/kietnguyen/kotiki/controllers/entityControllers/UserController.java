package com.kietnguyen.kotiki.controllers.entityControllers;

import com.kietnguyen.models.AppUser;
import com.kietnguyen.services.UserService;
import com.kietnguyen.services.tools.ServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/add")
    public void add(@RequestBody AppUser user) throws ServicesException {
        userService.add(user);
    }

    @GetMapping(value = "/get/{id}")
    public AppUser get(@PathVariable("id") Integer id) throws ServicesException {
        return userService.get(id);
    }

    @GetMapping(value = "/getAll")
    public List<AppUser> getAll() throws ServicesException {
        return userService.getAll();
    }

    @RequestMapping(value = "/delete/{userId}")
    public String deleteUser(@PathVariable(value = "userId") Integer id) throws ServicesException {
        userService.delete(id);

        return "redirect:/";
    }

    @GetMapping(value = "/getInfor/{id}")
    public String getInfor(@PathVariable("id") Integer id) throws ServicesException {
        return userService.get(id).toString();
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute("user") AppUser user) throws ServicesException {
        userService.add(user);

        return "redirect:/";
    }
}
