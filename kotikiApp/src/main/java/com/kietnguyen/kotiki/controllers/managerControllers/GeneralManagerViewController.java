package com.kietnguyen.kotiki.controllers.managerControllers;

import com.kietnguyen.models.AppRole;
import com.kietnguyen.models.AppUser;
import com.kietnguyen.models.Cat;
import com.kietnguyen.models.Owner;
import com.kietnguyen.services.*;
import com.kietnguyen.services.tools.ServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/managerView")
public class GeneralManagerViewController {
    @Autowired
    OwnerService ownerService;
    @Autowired
    UserService userService;
    @Autowired
    CatService catService;
    @Autowired
    AppRoleService appRoleService;
    @Autowired
    FilteringService filteringService;

    @RequestMapping("/ownerManager")
    public String viewHomeOwner(Model model) throws ServicesException {
        List<Owner> owners = ownerService.getAll();
        model.addAttribute("owners", owners);

        return "index_owner";
    }

    @RequestMapping("/catManager")
    public String viewHomeCat(Model model) throws ServicesException {
        List<Cat> catList;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN")))
        {
            catList = catService.getAll();

        } else
        {
            catList = filteringService.getAll();

        }

        model.addAttribute("catList", catList);

        return "index_cat";
    }

    @RequestMapping("/userManager")
    public String viewHomeUser(Model model) throws ServicesException {
        List<AppUser> userList = userService.getAll();
        model.addAttribute("userList", userList);

        return "index_user";
    }

    @RequestMapping("/catInfo/{id}")
    public String catInfo(Model model, @PathVariable(name = "id") Integer id) throws ServicesException {
        Cat cat = catService.get(id);
        model.addAttribute("cat", id);

        return "infor_cat";
    }
}
