package com.ufr.croissantshow.service.implementation;

import com.ufr.croissantshow.dao.IRoleDao;
import com.ufr.croissantshow.dao.IUserDao;
import com.ufr.croissantshow.exception.UserNotFoundException;
import com.ufr.croissantshow.modele.Role;
import com.ufr.croissantshow.modele.User;
import com.ufr.croissantshow.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IRoleDao roleDao;

    @Override
    public void addUser(User user) throws DataIntegrityViolationException {
        Role role = roleDao.findRoleByRoleName("ROLE_USER");
        user.setRole(role);
        user.setEnabled(false);
        userDao.save(user);
    }

    @Override
    public void updateUser(User user) throws DataIntegrityViolationException {
        userDao.save(user);
    }

    @Override
    public User getUserById(int userId) throws UserNotFoundException {

        return userDao.findById(userId).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public void enableUser(User user) {
        user.setEnabled(true);
        userDao.save(user);
    }

}
