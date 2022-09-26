package com.ufr.croissantshow.service.implementation;

import com.ufr.croissantshow.dao.IUserDao;
import com.ufr.croissantshow.modele.Utilisateur;
import com.ufr.croissantshow.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements IUserService {

    @Autowired
    private IUserDao userDao;

    // Exemple
    public Utilisateur getUserById(int userId){
        return userDao.findById(userId).get();
    }
}
