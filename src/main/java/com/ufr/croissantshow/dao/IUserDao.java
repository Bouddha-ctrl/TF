package com.ufr.croissantshow.dao;

import com.ufr.croissantshow.modele.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao extends JpaRepository<Utilisateur, Integer> {

    public Utilisateur getUtilisateurByIdentifiant(String login);
}
