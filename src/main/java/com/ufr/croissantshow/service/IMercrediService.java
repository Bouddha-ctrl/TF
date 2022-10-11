package com.ufr.croissantshow.service;

import com.ufr.croissantshow.exception.MercrediNotFoundException;
import com.ufr.croissantshow.modele.Mercredi;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

public interface IMercrediService {

    public void addMercredi(Mercredi mercredi) throws DataIntegrityViolationException;

    public void updateMercredi(Mercredi mercredi) throws DataIntegrityViolationException, MercrediNotFoundException;

    public void annulerMercredi(Mercredi mercredi);

    public Mercredi getMercrediById(int mId) throws MercrediNotFoundException;

    public List<Mercredi> getAllNextMercredis();

}
