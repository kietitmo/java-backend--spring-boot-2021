package com.kietnguyen.kotiki.controllers.entityControllers;

import com.kietnguyen.models.AppRole;
import com.kietnguyen.services.AppRoleService;
import com.kietnguyen.services.tools.ServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/role")
public class RoleController {
    @Autowired
    AppRoleService appRoleService;

    @PostMapping(value = "/add")
    public void add(@RequestBody AppRole role) throws ServicesException {
        appRoleService.add(role);
    }

    @GetMapping(value = "/get/{id}")
    public AppRole get(@PathVariable("id") Integer id) throws ServicesException {
        return appRoleService.get(id);
    }

    @GetMapping(value = "/getAll")
    public List<AppRole> getAll() throws ServicesException {
        return appRoleService.getAll();
    }

    @PutMapping(value = "/update/{id}")
    public boolean update(@PathVariable("id") Integer id, @RequestBody AppRole role) throws ServicesException {
        AppRole role1 = appRoleService.get(id);
        role1.clone(role);
        return appRoleService.update(role1);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable Integer id) throws ServicesException {
        appRoleService.delete(id);
        return "deleted";
    }

    @GetMapping(value = "/getInfor/{id}")
    public String getInfor(@PathVariable("id") Integer id) throws ServicesException {
        return appRoleService.get(id).toString();
    }
}
