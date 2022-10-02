package com.ufr.croissantshow.dao;

import com.ufr.croissantshow.modele.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao extends JpaRepository<User, Integer> {
    public User getUserByUsername(String username);
}
