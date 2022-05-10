package com.kietnguyen.kotiki.controllers.managerControllers;

import com.kietnguyen.models.AppRole;
import com.kietnguyen.models.AppUser;
import com.kietnguyen.models.Cat;
import com.kietnguyen.models.Owner;
import com.kietnguyen.services.AppRoleService;
import com.kietnguyen.services.CatService;
import com.kietnguyen.services.OwnerService;
import com.kietnguyen.services.UserService;
import com.kietnguyen.services.tools.ServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/managerTool")
public class ManagerToolsController {
    @Autowired
    OwnerService ownerService;
    @Autowired
    UserService userService;
    @Autowired
    CatService catService;
    @Autowired
    AppRoleService appRoleService;

    @RequestMapping("/newOwner")
    public String newOwner(Model model) {
        Owner owner = new Owner();
        model.addAttribute("owner", owner);

        return "new_owner";
    }

    @RequestMapping("/newCat")
    public String newCat(Model model) throws ServicesException {
        Cat cat = new Cat();
        List<Owner> owners = ownerService.getAll();
        model.addAttribute("cat", cat);
        model.addAttribute("owners", owners);
        return "new_cat";
    }

    @RequestMapping("/newUser")
    public String newUser(Model model) throws ServicesException {
        AppUser user = new AppUser();
        List<Owner> owners = ownerService.getAll();
        List<AppRole> roles = appRoleService.getAll();
        model.addAttribute("user", user);
        model.addAttribute("owners", owners);
        model.addAttribute("roles", roles);
        return "new_user";
    }

    @RequestMapping("/updateUser/{id}")
    public ModelAndView updateUser(@PathVariable(name = "id") Integer id, Model model) throws ServicesException {
        ModelAndView mav = new ModelAndView("update_user");
        List<Owner> owners = ownerService.getAll();
        List<AppRole> roles = appRoleService.getAll();

        AppUser user = userService.get(id);
        mav.addObject("user", user);
        model.addAttribute("owners", owners);
        model.addAttribute("roles", roles);
        return mav;
    }

    @RequestMapping("/updateOwner/{id}")
    public ModelAndView updateOwner(@PathVariable(name = "id") Integer id) throws ServicesException {
        ModelAndView mav = new ModelAndView("update_owner");

        Owner owner = ownerService.get(id);
        mav.addObject("owner", owner);
        return mav;
    }

    @RequestMapping("/updateCat/{id}")
    public ModelAndView updateCat(@PathVariable(name = "id") Integer id) throws ServicesException {
        ModelAndView mav = new ModelAndView("update_cat");

        Cat cat = catService.get(id);
        List<Owner> owners = ownerService.getAll();

        mav.addObject("cat", cat);
        mav.addObject("owners",owners);
        return mav;
    }
}
