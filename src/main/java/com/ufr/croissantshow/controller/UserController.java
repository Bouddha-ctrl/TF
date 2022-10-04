package com.ufr.croissantshow.controller;


import com.ufr.croissantshow.exception.UserNotFoundException;
import com.ufr.croissantshow.modele.User;
import com.ufr.croissantshow.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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

    @RequestMapping("/admin/enableuser/list")
    public String enableuserList(Model model){
        List<User> users = userService.getAllUsers()
                .stream().filter(user -> !user.isEnabled())
                .collect(Collectors.toList());
        model.addAttribute("users",users);

        return "admin/enableUserList";
    }

    @GetMapping("/admin/enable/{id}")
    public String enableUser(@PathVariable("id") String id)  {
        try{
            User user = userService.getUserById(Integer.parseInt(id));
            userService.enableUser(user);
        }catch(Exception ex){

        }

        return "redirect:/admin/enableuser/list";
    }

    @RequestMapping("/login")
    public String login(){

        return "login";
    }

    @RequestMapping("/signup")
    public String signup(Model model){
        model.addAttribute("user",new User());
        return "create_account";
    }

    @PostMapping(value = "/createUser")
    public String createUser(@ModelAttribute("user") User user){ //@Valid

        userService.addUser(user);
        return "redirect:/";
    }


}
