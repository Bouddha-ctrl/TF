package com.ufr.croissantshow.service;

import com.ufr.croissantshow.exception.MercrediNotFoundException;
import com.ufr.croissantshow.modele.Mercredi;
import com.ufr.croissantshow.modele.User;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

public interface IMercrediService {

    public void addMercredi(Mercredi mercredi) throws DataIntegrityViolationException;

    public void updateMercredi(Mercredi mercredi) throws DataIntegrityViolationException;

    public void annulerMercredi(Mercredi mercredi);

    public Mercredi getMercrediById(int mId) throws MercrediNotFoundException;

    public List<Mercredi> getAllNextMercredis();

    public List<User> getAllParticipantByMercredi(int idMercredi) throws MercrediNotFoundException;
    public void subscribe(Mercredi mercredi, User user) throws Exception;

    public void unsubscribe(Mercredi mercredi, User user) throws Exception;

    public void setMercrediResponsable(Mercredi mercredi, User user);

}
