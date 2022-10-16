package com.ufr.croissantshow.service.implementation;

import com.ufr.croissantshow.dao.IMercrediDao;
import com.ufr.croissantshow.dao.IUserDao;
import com.ufr.croissantshow.exception.MercrediNotFoundException;
import com.ufr.croissantshow.modele.Mercredi;
import com.ufr.croissantshow.modele.User;
import com.ufr.croissantshow.service.IMercrediService;
import com.ufr.croissantshow.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MercrediServiceImp implements IMercrediService {

    @Autowired
    private IMercrediDao mDao;

    @Autowired
    private IUserDao userDao;

    @Autowired
    @Lazy
    private IUserService userService;

    @Override
    public void addMercredi(Mercredi mercredi) throws DataIntegrityViolationException {
        mercredi.setMercrediAnnule(false);
        mercredi.setPresents(userService.getAllEnabledUsers());
        mDao.save(mercredi);
    }

    @Override
    public void updateMercredi(Mercredi mercredi) throws DataIntegrityViolationException {
        mDao.save(mercredi);
    }

    @Override
    public void annulerMercredi(Mercredi mercredi) {
        mercredi.setMercrediAnnule(true);
        mDao.save(mercredi);
    }

    @Override
    public Mercredi getMercrediById(int mId) throws MercrediNotFoundException {
        return mDao.findById(mId).orElseThrow(MercrediNotFoundException::new);
    }

    @Override
    public List<Mercredi> getAllNextMercredis() {
        return mDao.findAll()
                .stream()
                .filter(m -> m.getDate().after(new Date()))
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getAllParticipantByMercredi(int idMercredi) throws MercrediNotFoundException {
        Mercredi mercredi = mDao.findById(idMercredi).orElseThrow(MercrediNotFoundException::new);
        return mercredi.getPresents();
    }

    @Override
    public void subscribe(Mercredi mercredi, User user) {
        mercredi.addUser(user);
        this.updateMercredi(mercredi);
    }

    @Override
    public void unsubscribe(Mercredi mercredi, User user) {
        if(mercredi.getResponsable()!=null && mercredi.getResponsable().equals(user)){
            mercredi.setResponsable(null);
        }
        mercredi.removeUser(user);
        this.updateMercredi(mercredi);
        userService.updateUser(user);
    }

    @Override
    public void setMercrediResponsable(Mercredi mercredi, User user){
        if(user != null && !mercredi.containUserByUsername(user.getUsername())){
            this.subscribe(mercredi,user);
        }
        mercredi.setResponsable(user);
        this.updateMercredi(mercredi);
    }
}
