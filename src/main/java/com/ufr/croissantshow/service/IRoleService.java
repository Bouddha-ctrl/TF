package com.ufr.croissantshow.service;

import com.ufr.croissantshow.modele.Role;
import com.ufr.croissantshow.modele.User;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface IRoleService {

    public void addRole(Role role) throws DataAccessException;
    public List<Role> getAllRoles();
}
