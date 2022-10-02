package com.ufr.croissantshow.service;

import com.ufr.croissantshow.modele.Role;
import org.springframework.dao.DataAccessException;

public interface IRoleService {

    public void addRole(Role role) throws DataAccessException;
}
