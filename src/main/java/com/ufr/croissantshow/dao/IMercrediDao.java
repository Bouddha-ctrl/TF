package com.ufr.croissantshow.dao;

import com.ufr.croissantshow.modele.Mercredi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMercrediDao extends JpaRepository<Mercredi, Integer> {
}
