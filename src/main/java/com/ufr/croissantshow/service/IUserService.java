package com.ufr.croissantshow.service;


import com.ufr.croissantshow.modele.Utilisateur;
import java.util.List;

public interface IUserService {
    public Utilisateur getUserById(int id);
    public List<Utilisateur> getAllUsers();

}
