package com.ufr.croissantshow.test.unitaire;

import com.ufr.croissantshow.exception.UserNotFoundException;
import com.ufr.croissantshow.modele.User;
import com.ufr.croissantshow.service.IUserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.TransactionSystemException;

@SpringBootTest
class UserServiceImpTest {

    @Autowired
    private IUserService userS;


    @Test
    void addUser() {

        User user = User.builder()
                .enabled(false)
                .username("user1user1")
                .password("password")
                .lastname("nom")
                .firstname("prenom")
                .build();
        userS.addUser(user);

        try{
            userS.getUserById(user.getId());
            Assert.assertTrue(true);
        }catch(Exception ex){
            Assert.assertTrue(false);
        }
    }

    @Test
    void addUserWithSameUsername() {

        User user = User.builder()
                .username("addUserWith")
                .password("password")
                .lastname("nom")
                .firstname("prenom")
                .build();
        userS.addUser(user);

        User user2 = user.toBuilder()
                        .id(0)
                        .build();

        try{
            userS.addUser(user2);
            Assert.assertTrue(false);
        }catch(DataIntegrityViolationException ex){
            Assert.assertTrue(true);
        }
    }

    @Test
    void addUserWithShortUsername() { //ConstraintViolation
        User user = User.builder()
                .username("addU")
                .password("password")
                .lastname("nom")
                .firstname("prenom")
                .build();

        try{
            userS.addUser(user);
            Assert.assertTrue(false);
        }catch(TransactionSystemException ex){
            Assert.assertTrue(true);
        }
    }

    @Test
    void addUserWithMissingProperty() { //ConstraintViolation
        User user = User.builder()
                .password("password")
                .lastname("nom")
                .firstname("prenom")
                .build();

        try{
            userS.addUser(user);
            Assert.assertTrue(false);
        }catch(TransactionSystemException ex){
            Assert.assertTrue(true);
        }
    }

    @Test
    void enableUser(){

        User user = User.builder()
                .username("enableUser")
                .password("password")
                .lastname("nom")
                .firstname("prenom")
                .build();
        userS.addUser(user);

        user.setEnabled(true);
        userS.updateUser(user);

        Assert.assertEquals(true, user.isEnabled());
    }

    @Test
    void disableUser(){

        User user = User.builder()
                .username("disableUser")
                .password("password")
                .lastname("nom")
                .firstname("prenom")
                .build();
        userS.addUser(user);

        user.setEnabled(false);
        userS.updateUser(user);

        Assert.assertEquals(false, user.isEnabled());
    }

    @Test
    void getExistingUser(){
        User user1 = User.builder()
                .username("existing")
                .password("password")
                .lastname("nom")
                .firstname("prenom")
                .build();
        userS.addUser(user1);

        try{
            userS.getUserById(user1.getId());
            Assert.assertTrue(true);
        }catch(Exception ex){
            Assert.assertTrue(false);
        }
    }

    @Test
    void getUnexistingUser(){

        try{
            User user2 = userS.getUserById(69);

            Assert.assertTrue(false);
        }catch(UserNotFoundException ex){
            Assert.assertTrue(true);
        }catch(Exception e){
            Assert.assertTrue(false);
        }
    }


}