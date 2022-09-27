package com.ufr.croissantshow.dao;

import com.ufr.croissantshow.modele.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleDao extends JpaRepository<Role, Integer> {
}
