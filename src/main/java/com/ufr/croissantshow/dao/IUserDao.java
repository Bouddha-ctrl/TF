package com.ufr.croissantshow.dao;

import com.ufr.croissantshow.modele.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IUserDao extends JpaRepository<User, Integer> {
    public User getUserByUsername(String username);

    @Modifying
    @Transactional
    @Query(value = "delete from utilisateur_present where utilisateur_id=?1",nativeQuery = true)
    public void deleteAllMercredis(int idUser);
}
