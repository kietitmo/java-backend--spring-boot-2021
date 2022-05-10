package com.kietnguyen.services;

import com.kietnguyen.models.AppUser;
import com.kietnguyen.services.tools.ServicesException;

public interface UserService extends Service<AppUser>{
    public AppUser getByUsername(String username) throws ServicesException;
}
