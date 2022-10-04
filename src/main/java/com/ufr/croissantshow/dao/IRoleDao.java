package com.ufr.croissantshow.dao;

import com.ufr.croissantshow.modele.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleDao extends JpaRepository<Role, Integer> {

    public Role findRoleByRoleName(String role);


}
