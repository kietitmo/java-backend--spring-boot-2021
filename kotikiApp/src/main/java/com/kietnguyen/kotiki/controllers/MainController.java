package com.kietnguyen.kotiki.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("")
public class MainController {

    @RequestMapping(value = { "/welcomePage" })
    public String welcomePage(Model model) {
        return "welcomePage";
    }

    @RequestMapping(value = { "/", "/home" })
    public String homePage(Model model) {
        return "home_page";
    }

    @RequestMapping(value = "/loginPage")
    public String loginPage(Model model) {
        return "loginPage";
    }

    @RequestMapping(value = "/loginError")
    public String loginError(Model model) {
        return "login_error";
    }

    @RequestMapping(value = "/403")
    public String accessDenied(Model model) {
        return "403Page";
    }

}
