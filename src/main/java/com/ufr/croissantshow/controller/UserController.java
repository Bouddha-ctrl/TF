package com.ufr.croissantshow.controller;

import com.ufr.croissantshow.modele.Mercredi;
import com.ufr.croissantshow.modele.User;
import com.ufr.croissantshow.service.IMercrediService;
import com.ufr.croissantshow.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


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

    @GetMapping("/responsable/{id}")
    public String beManager(@PathVariable("id") String idMercredi, Principal pricipale, Model model){

        try{
            User user = userService.getUserByUsername(pricipale.getName());
            Mercredi mercredi = mService.getMercrediById(Integer.parseInt(idMercredi));
            mercredi.setResponsable(user);
            mService.updateMercredi(mercredi);
        }catch(Exception ex){
            return "redirect:/user/mercredi?error";
        }

        return "redirect:/user/mercredi?success";
    }
}
