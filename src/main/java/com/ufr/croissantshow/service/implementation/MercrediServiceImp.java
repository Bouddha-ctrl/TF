package com.ufr.croissantshow.service.implementation;

import com.ufr.croissantshow.dao.IMercrediDao;
import com.ufr.croissantshow.dao.IUserDao;
import com.ufr.croissantshow.exception.MercrediNotFoundException;
import com.ufr.croissantshow.modele.Mercredi;
import com.ufr.croissantshow.service.IMercrediService;
import com.ufr.croissantshow.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
