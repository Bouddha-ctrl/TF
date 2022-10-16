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

    @GetMapping(value={"/mercredi/{id}","/mercredi"})
    public String mercrediList(@PathVariable(name="id",required = false) String id, Model model){
        if(id != null){
            try{
                int idMercredi = Integer.parseInt(id);
                model.addAttribute("listParticipant",mService.getAllParticipantByMercredi(idMercredi));
            }catch(Exception ex){
                return "redirect:/user/mercredi?error";
            }
        }
        model.addAttribute("mercredis",mService.getAllNextMercredis());
        return "user/user_mercredi";
    }

    @GetMapping("/responsable/{id}")
    public String beManager(@PathVariable("id") String id, Principal pricipale, Model model){

        try{
            int idMercredi = Integer.parseInt(id);
            User user = userService.getUserByUsername(pricipale.getName());
            Mercredi mercredi = mService.getMercrediById(idMercredi);

            mService.setMercrediResponsable(mercredi, user);
        }catch(Exception ex){
            return "redirect:/user/mercredi?error";
        }
        return "redirect:/user/mercredi?success";
    }

    @GetMapping("/subscribe/{id}")
    public String subscribe(@PathVariable("id") String id, Principal pricipale, Model model){

        try{
            int idMercredi = Integer.parseInt(id);
            User user = userService.getUserByUsername(pricipale.getName());
            Mercredi mercredi = mService.getMercrediById(idMercredi);

            mService.subscribe(mercredi, user);
        }catch (Exception ex){
            return "redirect:/user/mercredi?error";
        }
        return "redirect:/user/mercredi?success";
    }

    @GetMapping("/unsubscribe/{id}")
    public String unsubscribe(@PathVariable("id") String id, Principal pricipale, Model model){

        try{
            int idMercredi = Integer.parseInt(id);
            User user = userService.getUserByUsername(pricipale.getName());
            Mercredi mercredi = mService.getMercrediById(idMercredi);

            mService.unsubscribe(mercredi, user);
        }catch (Exception ex){
            return "redirect:/user/mercredi?error";
        }
        return "redirect:/user/mercredi?success";
    }
}
