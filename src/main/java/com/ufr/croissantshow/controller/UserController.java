package com.ufr.croissantshow.controller;

import com.ufr.croissantshow.service.IMercrediService;
import com.ufr.croissantshow.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IMercrediService mService;

    @GetMapping("/home")
    public String userHomePage(){

        return "user/user_homepage"; // ressource/templates/...
    }

    @GetMapping("/mercredi")
    public String mercrediList(Model model){

        model.addAttribute("mercredis",mService.getAllNextMercredis());
        return "user/user_mercredi";
    }
}
