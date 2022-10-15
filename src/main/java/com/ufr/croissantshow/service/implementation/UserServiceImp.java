package com.ufr.croissantshow.service.implementation;

import com.ufr.croissantshow.dao.IRoleDao;
import com.ufr.croissantshow.dao.IUserDao;
import com.ufr.croissantshow.exception.UserNotFoundException;
import com.ufr.croissantshow.modele.Mercredi;
import com.ufr.croissantshow.modele.Role;
import com.ufr.croissantshow.modele.User;
import com.ufr.croissantshow.service.IMercrediService;
import com.ufr.croissantshow.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IRoleDao roleDao;

    @Autowired
    @Lazy
    private IMercrediService mercrediService;

    @Override
    public void addUser(User user) throws DataIntegrityViolationException {
        Role role = roleDao.findRoleByRoleName("ROLE_USER");
        user.setRole(role);
        user.setEnabled(false);
        userDao.save(user);
    }

    @Override
    public void updateProfil(User olduser) throws UserNotFoundException {
        User newUser = this.getUserByUsername(olduser.getUsername());
        newUser.setFirstname(olduser.getFirstname());
        newUser.setLastname(olduser.getLastname());
        newUser.setEmail(olduser.getEmail());
        newUser.setPassword(olduser.getPassword());
        this.updateUser(newUser);
    }

    @Override
    public void updateUser(User user) throws DataIntegrityViolationException {
        userDao.save(user);
    }


    private void deleteAllMercredis(User user){
        user.getMercredis().forEach(m ->
                mercrediService.setMercrediResponsable(m, null)
        );
        userDao.deleteAllMercredis(user.getId());
    }
    @Override
    public void deleteUserById(int id) throws UserNotFoundException {
        User user = this.getUserById(id);
        this.deleteAllMercredis(user);
        userDao.delete(user);
    }

    @Override
    public User getUserById(int userId) throws UserNotFoundException {
        return userDao.findById(userId).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User getUserByUsername(String username) throws UserNotFoundException {
        User user = userDao.getUserByUsername(username);
        if(user == null)
            throw new UserNotFoundException();
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll()
                .stream()
                .filter(user -> "ROLE_USER".equals(user.getRole().getRoleName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getAllEnabledUsers() {
        return userDao.findAll()
                .stream()
                .filter(user -> "ROLE_USER".equals(user.getRole().getRoleName()) && user.isEnabled())
                .collect(Collectors.toList());
    }

    @Override
    public void enableUser(User user) {
        user.setEnabled(true);
        this.addUserToAllMercredi(user);
        userDao.save(user);
    }

    @Override
    public void disableUser(User user) {
        user.setEnabled(false);
        userDao.save(user);
    }

    @Override
    public boolean isUsernameExists(User user) {
        return userDao.getUserByUsername(user.getUsername()) != null;
    }

    private void addUserToAllMercredi(User user){
        if(user == null)
            return;
        
        List<Mercredi> mercredis = mercrediService.getAllNextMercredis();
        for(Mercredi m: mercredis)
            m.addUser(user);
    }
}
