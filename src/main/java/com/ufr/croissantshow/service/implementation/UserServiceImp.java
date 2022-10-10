package com.ufr.croissantshow.service.implementation;

import com.ufr.croissantshow.dao.IRoleDao;
import com.ufr.croissantshow.dao.IUserDao;
import com.ufr.croissantshow.exception.UserNotFoundException;
import com.ufr.croissantshow.modele.Role;
import com.ufr.croissantshow.modele.User;
import com.ufr.croissantshow.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public void updateUser(User olduser) throws DataIntegrityViolationException, UserNotFoundException {
        User newUser = this.getUserByUsername(olduser.getUsername());
        newUser.setFirstname(olduser.getFirstname());
        newUser.setLastname(olduser.getLastname());
        newUser.setEmail(olduser.getEmail());
        newUser.setPassword(olduser.getPassword());
        userDao.save(newUser);
    }

    @Override
    public void deleteUserById(int id) throws UserNotFoundException {
        User user = this.getUserById(id);
        userDao.delete(user);
    }

    @Override
    public User getUserById(int userId) throws UserNotFoundException {

        return userDao.findById(userId).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User getUserByUsername(String username) throws UserNotFoundException{
        Optional<User> user = Optional.of(userDao.getUserByUsername(username));
        return user.orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll()
                .stream()
                .filter(user -> "ROLE_USER".equals(user.getRole().getRoleName()))
                .collect(Collectors.toList());
    }

    @Override
    public void enableUser(User user) {
        user.setEnabled(true);
        userDao.save(user);
    }

    @Override
    public void disableUser(User user) {
        user.setEnabled(false);
        userDao.save(user);
    }

    @Override
    public boolean usarnameExiste(User user) {
        return userDao.getUserByUsername(user.getUsername()) != null;
    }

}
