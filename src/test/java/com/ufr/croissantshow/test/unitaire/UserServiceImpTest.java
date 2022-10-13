package com.ufr.croissantshow.test.unitaire;

import com.ufr.croissantshow.exception.UserNotFoundException;
import com.ufr.croissantshow.modele.User;
import com.ufr.croissantshow.service.IUserService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.TransactionSystemException;

import java.util.List;

@SpringBootTest
class UserServiceImpTest {

    @Autowired
    private IUserService userS;

    @Test
    void testAddUser() throws UserNotFoundException {
        User user = User.builder()
                .enabled(false)
                .username("testAddUser")
                .password("password")
                .lastname("nom")
                .firstname("prenom")
                .build();
        userS.addUser(user);

        User user2 = userS.getUserById(user.getId());
        Assert.assertEquals(user.getUsername(), user2.getUsername());


        List<User> users = userS.getAllUsers();
        User userFound = null;

        for (User u: users) {
            if(u != null && u.getUsername().equals(user.getUsername())){
                userFound = u;
                break;
            }
        }
        Assert.assertEquals(userFound.getUsername(), user.getUsername());
    }

    @Test
    void testAddUserWithSameUsername() {
        User user = User.builder()
                .username("addUserSameUsername")
                .password("password")
                .lastname("nom")
                .firstname("prenom")
                .build();
        userS.addUser(user);

        User user2 = User.builder()
                .username("addUserSameUsername")
                .password("password")
                .lastname("nom")
                .firstname("prenom")
                .build();

        Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
            userS.addUser(user2);
        });
    }

    @Test
    void testAddUserWithUsernameTooShort() {
        User user = User.builder()
                .username("ab")
                .password("password")
                .lastname("nom")
                .firstname("prenom")
                .build();

        Assertions.assertThrows(TransactionSystemException.class, () -> {
            userS.addUser(user);
        });
    }

    @Test
    void testAddUserWithUsernameTooLong() {
        User user = User.builder()
                .enabled(false)
                .username("testAddUserWithUsernameTooLong20")
                .password("password")
                .lastname("nom")
                .firstname("prenom")
                .build();

        Assertions.assertThrows(TransactionSystemException.class, () -> {
            userS.addUser(user);
        });
    }

    @Test
    void testAddUserWithMissingUsername() {
        User user = User.builder()
                .password("password")
                .lastname("nom")
                .firstname("prenom")
                .build();

        Assertions.assertThrows(TransactionSystemException.class, () -> {
            userS.addUser(user);
        });
    }

    @Test
    void testAddUserWithMissingPassword() {
        User user = User.builder()
                .username("testAddUserWithMissingPassword")
                .lastname("nom")
                .firstname("prenom")
                .build();

        Assertions.assertThrows(TransactionSystemException.class, () -> {
            userS.addUser(user);
        });
    }

    @Test
    void testAddUserWithMissingLastname() {
        User user = User.builder()
                .username("addNoLastname")
                .password("password")
                .firstname("prenom")
                .build();

        Assertions.assertThrows(TransactionSystemException.class, () -> {
            userS.addUser(user);
        });
    }

    @Test
    void testAddUserWithMissingFirstname() {
        User user = User.builder()
                .username("testNoFirstname")
                .password("password")
                .lastname("nom")
                .build();

        Assertions.assertThrows(TransactionSystemException.class, () -> {
            userS.addUser(user);
        });
    }

    @Test
    void testEnableUser() throws UserNotFoundException {
        User user = User.builder()
                .username("testEnableUser")
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
    void testEnableUserTwice() throws UserNotFoundException {
        User user = User.builder()
                .username("testEnableUserTwice")
                .password("password")
                .lastname("nom")
                .firstname("prenom")
                .build();
        userS.addUser(user);

        user.setEnabled(true);
        user.setEnabled(true);
        userS.updateUser(user);

        Assert.assertEquals(true, user.isEnabled());
    }

    @Test
    void testDisableUser() throws UserNotFoundException {
        User user = User.builder()
                .username("testDisableUser")
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
    void testDisableUserTwice() throws UserNotFoundException {
        User user = User.builder()
                .username("disableUserTwice")
                .password("password")
                .lastname("nom")
                .firstname("prenom")
                .build();
        userS.addUser(user);

        user.setEnabled(false);
        user.setEnabled(false);
        userS.updateUser(user);

        Assert.assertEquals(false, user.isEnabled());
    }

    @Test
    void testGetExistingUser() throws UserNotFoundException {
        User user1 = User.builder()
                .username("getExistingUser")
                .password("password")
                .lastname("nom")
                .firstname("prenom")
                .build();
        userS.addUser(user1);

        User user2 = userS.getUserById(user1.getId());
        Assert.assertEquals(user1.getUsername(), user2.getUsername());
    }

    @Test
    void testGetNonExistingUser(){
        Assertions.assertThrows(UserNotFoundException.class, () -> {
            userS.getUserById(99999);
        });
    }

    @Test
    void testGetExistingUserByUsername() throws UserNotFoundException {
        User user1 = User.builder()
                .username("existingByUsername")
                .password("password")
                .lastname("nom")
                .firstname("prenom")
                .build();
        userS.addUser(user1);

        User user2 = userS.getUserByUsername("existingByUsername");
        Assert.assertEquals(user1.getUsername(), user2.getUsername());
    }

    @Test
    void testGetNonExistingUserByUsername() {
        Assertions.assertThrows(UserNotFoundException.class, () -> {
            userS.getUserByUsername("testGetNonExistingUserByUsername");
        });
    }

    @Test
    void testDeleteExistingUser() throws UserNotFoundException {
        User user = User.builder()
                .username("testDeleteUser")
                .password("password")
                .lastname("nom")
                .firstname("prenom")
                .build();
        userS.addUser(user);

        userS.deleteUserById(user.getId());


        List<User> users = userS.getAllUsers();
        User userFound = null;

        for (User u: users) {
            if(u != null && u.getUsername().equals(user.getUsername())){
                userFound = u;
                break;
            }
        }
        Assert.assertNull(userFound);
    }

    @Test
    void testDeleteNonExistingUser() throws UserNotFoundException {
        Assertions.assertThrows(UserNotFoundException.class, () -> {
            userS.deleteUserById(99999);
        });
    }
}