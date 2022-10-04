package com.ufr.croissantshow.service;


import com.ufr.croissantshow.exception.UserNotFoundException;
import com.ufr.croissantshow.modele.User;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

public interface IUserService {

    public void addUser(User user) throws DataIntegrityViolationException;
    public void updateUser(User user) throws DataIntegrityViolationException;

    public User getUserById(int id) throws UserNotFoundException;
    public List<User> getAllUsers();

    public void enableUser(User user);

}
