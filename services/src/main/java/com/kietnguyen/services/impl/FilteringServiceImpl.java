package com.kietnguyen.services.impl;

import com.kietnguyen.enums.CatBreed;
import com.kietnguyen.enums.CatColor;
import com.kietnguyen.models.AppUser;
import com.kietnguyen.models.Cat;
import com.kietnguyen.services.CatService;
import com.kietnguyen.services.FilteringService;
import com.kietnguyen.services.UserService;
import com.kietnguyen.services.tools.ServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilteringServiceImpl implements FilteringService {
    @Autowired
    CatService catService;

    @Autowired
    UserService userService;
    @Override
    public List<Cat> getCatByColor(CatColor color) throws ServicesException {
        try {
            AppUser user = null;
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null)
            {
                user = userService.getByUsername(authentication.getName());
            }

            List<Cat> catList = catService.getCatByColor(color);
            List<Cat> resCats = new ArrayList<Cat>();
            for (Cat cat: catList
            ) {
                assert user != null;
                if (cat.getOwner() != null)
                {
                    if (cat.getOwner().getName().equals(user.getOwner().getName()))
                    {
                        resCats.add(cat);
                    }
                }
            }
            return resCats;
        } catch (Exception e) {
            throw new ServicesException(e.getMessage());
        }
    }

    @Override
    public List<Cat> getCatByBreed(CatBreed breed) throws ServicesException {
        try {
            AppUser user = null;
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null)
            {
                user = userService.getByUsername(authentication.getName());
            }

            List<Cat> catList = catService.getCatByBreed(breed);
            List<Cat> resCats = new ArrayList<Cat>();
            for (Cat cat: catList
            ) {
                assert user != null;
                if (cat.getOwner() != null)
                {
                    if (cat.getOwner().getName().equals(user.getOwner().getName()))
                    {
                        resCats.add(cat);
                    }
                }
            }
            return resCats;
        } catch (Exception e) {
            throw new ServicesException(e.getMessage());
        }
    }

    @Override
    public List<Cat> getAll() throws ServicesException {
        try {
            AppUser user = null;
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null)
            {
                user = userService.getByUsername(authentication.getName());
            }

            List<Cat> catList = catService.getAll();
            List<Cat> resCats = new ArrayList<Cat>();
            for (Cat cat: catList
            ) {
                assert user != null;
                if (cat.getOwner() != null)
                {
                    if (cat.getOwner().getName().equals(user.getOwner().getName()))
                    {
                        resCats.add(cat);
                    }
                }
            }
            return resCats;
        } catch (Exception e) {
            throw new ServicesException(e.getMessage());
        }
    }

    public String currentUserName(Authentication authentication) {

        if (authentication != null)
            return authentication.getName();
        else
            return "";
    }
}
