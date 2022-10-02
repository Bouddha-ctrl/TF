package com.ufr.croissantshow.service.implementation;

import com.ufr.croissantshow.dao.IRoleDao;
import com.ufr.croissantshow.modele.Role;
import com.ufr.croissantshow.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImp implements IRoleService {

    @Autowired
    private IRoleDao rDao;

    @Override
    public void addRole(Role role) throws DataAccessException {
        rDao.save(role);
    }
}
