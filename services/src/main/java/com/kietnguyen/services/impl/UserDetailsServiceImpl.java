package com.kietnguyen.services.impl;
import java.util.ArrayList;
import java.util.List;

import com.kietnguyen.models.AppUser;
import com.kietnguyen.models.Cat;
import com.kietnguyen.models.MyUserDetails;
import com.kietnguyen.repositories.AppRoleRepository;
import com.kietnguyen.repositories.AppUserRepository;
import com.kietnguyen.services.tools.ServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AppUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        AppUser user = userRepository.findUserAccount(username);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        System.out.println("Found User: " + user.getUserName());
        return new MyUserDetails(user);
    }
//
//    @Autowired
//    private AppUserRepository appUserRepository;
//
//    @Autowired
//    private AppRoleRepository appRoleRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        AppUser appUser = this.appUserRepository.findUserAccount(userName);
//
//        if (appUser == null) {
//            System.out.println("User not found! " + userName);
//            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
//        }
//
//        System.out.println("Found User: " + appUser.getUsername());
//
//        // [ROLE_USER, ROLE_ADMIN,..]
//        List<String> roleNames = appUser.getRoles();
//
//        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
//        if (roleNames != null) {
//            for (String role : roleNames) {
//                // ROLE_USER, ROLE_ADMIN,..
//                GrantedAuthority authority = new SimpleGrantedAuthority(role);
//                grantList.add(authority);
//            }
//        }
//
//        UserDetails userDetails = (UserDetails) new User(appUser.getUsername(), appUser.getPassword(), grantList);
//
//        return userDetails;
//    }
}
