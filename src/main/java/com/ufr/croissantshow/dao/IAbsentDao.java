package com.ufr.croissantshow.dao;

import com.ufr.croissantshow.modele.Absent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAbsentDao extends JpaRepository<Absent, Integer> {
}
