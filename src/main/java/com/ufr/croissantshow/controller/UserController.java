package com.ufr.croissantshow.controller;


import com.ufr.croissantshow.modele.User;
import com.ufr.croissantshow.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/")
    public String accueil(){
        return "accueil";
    }

    @RequestMapping("/user/home")
    public String userHomePage(){

        return "user/user_homepage"; // ressource/templates/...
    }

    @RequestMapping("/admin/home")
    public String adminHomePage(){

        return "admin/admin_homepage";
    }

    @RequestMapping("/admin/user/list")
    public String userList(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users",users);

        return "admin/userList";
    }

    @RequestMapping("/login")
    public String login(){

        return "login";
    }

    @RequestMapping("/createAccount")
    public String signup(){

        return "create_account";
    }
}
