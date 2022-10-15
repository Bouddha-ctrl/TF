package com.ufr.croissantshow.test.unitaire;

import com.ufr.croissantshow.modele.User;
import com.ufr.croissantshow.security.MyUserDetails;
import com.ufr.croissantshow.service.IUserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;

@SpringBootTest
class UserDetailsServiceImplTest {
    @Autowired
    private IUserService userS;

    @Autowired
    private UserDetailsService userDetailsS;


    @Test
    void testLoadUserByUsername() {
        User user = User.builder()
                .enabled(false)
                .username("loadUserByUsername")
                .password("password")
                .lastname("nom")
                .firstname("prenom")
                .email("truc@truc.com")
                .build();
        userS.addUser(user);

        MyUserDetails userDetails = (MyUserDetails) userDetailsS.loadUserByUsername("loadUserByUsername");

        Assert.assertEquals(user.getUsername(), userDetails.getUsername());
        Assert.assertEquals(user.getRole().getRoleName(), userDetails.getRoleName());
        Assert.assertEquals(user.getFirstname(), userDetails.getFirstName());
        Assert.assertEquals(user.getLastname(), userDetails.getLastName());
    }

}