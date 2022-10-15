package com.ufr.croissantshow.controller;

import com.ufr.croissantshow.exception.UserNotFoundException;
import com.ufr.croissantshow.modele.User;
import com.ufr.croissantshow.security.MyUserDetails;
import com.ufr.croissantshow.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class GeneralController {

    @Autowired
    private IUserService userService;

    @GetMapping("/")
    public String accueil(Authentication authentication){
        if (authentication != null){
            MyUserDetails user = (MyUserDetails) authentication.getPrincipal();
            if("ROLE_USER".equals(user.getRoleName()))
                return "redirect:/user/home";
            if("ROLE_ADMIN".equals(user.getRoleName()))
                return "redirect:/admin/home";
        }
        return "accueil";
    }

    @GetMapping("/login")
    public String login(){

        return "login";
    }

    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("user",new User());
        return "create_account";
    }

    @PostMapping(value = "/createUser")
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult result, Model model){ //@Valid
        if (result.hasErrors()) {
            return "create_account";
        }
        boolean usernameExiste = userService.isUsernameExists(user);
        if (usernameExiste) {
            result.rejectValue("username","error.user","Username already exists");
            return "create_account";
        }
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/profil")
    public String profil(Principal principal, Model model){

        String username = principal.getName();
        try{
            User user = userService.getUserByUsername(username);
            model.addAttribute("user",user);
        }catch(UserNotFoundException ex){
            return "error/500";
        }
        return "profil";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") @Valid User user,BindingResult result, Principal principal, Model model){

        if (result.hasErrors()) {
            return "profil";
        }
        String username = principal.getName();
        if (!username.equals(user.getUsername())){
            user.setUsername(username);
            result.rejectValue("username","error.user","Username can not be changed!");
            return "profil";
        }
        try{
            userService.updateProfil(user);
        }catch(Exception ex){
            return "error/500";
        }

        return "redirect:/profil?success";
    }
}
