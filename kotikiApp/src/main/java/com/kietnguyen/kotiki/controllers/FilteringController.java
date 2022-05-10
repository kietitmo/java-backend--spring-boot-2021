package com.kietnguyen.kotiki.controllers;

import com.kietnguyen.enums.CatBreed;
import com.kietnguyen.enums.CatColor;
import com.kietnguyen.models.Cat;
import com.kietnguyen.services.FilteringService;
import com.kietnguyen.services.tools.ServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/filtering")
public class FilteringController {
    @Autowired
    public FilteringService filteringService;

    @GetMapping(value = "/getByColor")
    public List<Cat> getByColor(@RequestParam(value = "color") String color) throws ServicesException {
        return filteringService.getCatByColor(CatColor.valueOf(color.toUpperCase()));
    }

    @GetMapping(value = "/getByBreed")
    public List<Cat> getByBreed(@RequestParam(value = "breed") String breed) throws ServicesException {
        return filteringService.getCatByBreed(CatBreed.valueOf(breed.toUpperCase()));
    }

    @GetMapping(value = "/username")
    @ResponseBody
    public String currentUserName(Authentication authentication) {
        return filteringService.currentUserName(authentication);
    }
}
