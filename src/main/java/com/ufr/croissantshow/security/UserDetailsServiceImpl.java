package com.ufr.croissantshow.security;

import com.ufr.croissantshow.dao.IUserDao;
import com.ufr.croissantshow.modele.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur user = userDao.getUtilisateurByIdentifiant(username);

        if (user == null) throw new UsernameNotFoundException("Could not find user");

        return new MyUserDetails(user);
    }
}
