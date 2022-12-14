package com.ufr.croissantshow.service;


import com.ufr.croissantshow.exception.UserNotFoundException;
import com.ufr.croissantshow.modele.User;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

public interface IUserService {

    public void addUser(User user) throws DataIntegrityViolationException;
    public void updateUser(User user) throws DataIntegrityViolationException;
    public void updateProfil(User user) throws UserNotFoundException;
    public void deleteUserById(int id) throws UserNotFoundException;
    public User getUserById(int id) throws UserNotFoundException;

    public User getUserByUsername(String username) throws UserNotFoundException;
    public List<User> getAllUsers();

    public List<User> getAllEnabledUsers();

    public void enableUser(User user);
    public void disableUser(User user);

    public boolean isUsernameExists(User user);

}
