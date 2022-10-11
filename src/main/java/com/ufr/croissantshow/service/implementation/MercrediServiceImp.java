package com.ufr.croissantshow.service.implementation;

import com.ufr.croissantshow.dao.IMercrediDao;
import com.ufr.croissantshow.exception.MercrediNotFoundException;
import com.ufr.croissantshow.modele.Mercredi;
import com.ufr.croissantshow.service.IMercrediService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MercrediServiceImp implements IMercrediService {

    private IMercrediDao mDao;

    @Override
    public void addMercredi(Mercredi mercredi) throws DataIntegrityViolationException {
        mDao.save(mercredi);
    }

    @Override
    public void updateMercredi(Mercredi mercredi) throws DataIntegrityViolationException, MercrediNotFoundException {

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
