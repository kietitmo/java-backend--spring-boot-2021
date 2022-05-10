package com.kietnguyen.services;

import com.kietnguyen.enums.CatBreed;
import com.kietnguyen.enums.CatColor;
import com.kietnguyen.models.Cat;
import com.kietnguyen.services.tools.ServicesException;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.logging.Filter;

public interface FilteringService {
    public List<Cat> getCatByColor(CatColor color) throws ServicesException;
    public List<Cat> getCatByBreed(CatBreed breed) throws ServicesException;
    public List<Cat> getAll() throws ServicesException;
    public String currentUserName(Authentication authentication);
}
