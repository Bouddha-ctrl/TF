package com.ufr.croissantshow.controller;

import com.ufr.croissantshow.modele.User;
import com.ufr.croissantshow.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IUserService userService;

    @GetMapping("/home")
    public String adminHomePage(){

        return "admin/admin_homepage";
    }

    @GetMapping("/user/list")
    public String userList(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users",users);

        return "admin/userList";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") String id, Model model){
        int idUser = Integer.parseInt(id);

        try{
            userService.deleteUserById(idUser);
        }catch(Exception ex){
            return "redirect:/admin/user/list?error";
        }

        return "redirect:/admin/user/list?success";
    }

    @GetMapping("/enable/{id}")
    public String enableUser(@PathVariable("id") String id)  {
        try{
            User user = userService.getUserById(Integer.parseInt(id));
            userService.enableUser(user);
        }catch(Exception ex){

        }
        return "redirect:/admin/user/list";
    }

    @GetMapping("/disable/{id}")
    public String disableUser(@PathVariable("id") String id)  {
        try{
            User user = userService.getUserById(Integer.parseInt(id));
            userService.disableUser(user);
        }catch(Exception ex){

        }
        return "redirect:/admin/user/list";
    }
}
