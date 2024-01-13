package com.laborator.FootballDatabase.Services;

import com.laborator.FootballDatabase.Domain.Awards;
import com.laborator.FootballDatabase.Repository.AwardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AwardsService {

    @Autowired private final AwardsRepository awardsRepository;

    @Autowired
    public AwardsService(AwardsRepository awardsRepository) {
        this.awardsRepository = awardsRepository;
    }

    public void addAward(Awards award) {
        awardsRepository.save(award);
    }

    public Awards getAwardByName(String name) {
        //return awardsRepository.findByName(name);
        return null;
    }

    public List<Awards> getAllAwards() {
        return awardsRepository.findAll();
    }

    public void updateAward(String name, Awards updatedAward) {
        Awards existingAward = getAwardByName(name);


        if (existingAward != null) {
            existingAward.setYear(updatedAward.getYear());
            awardsRepository.save(existingAward);
        }
    }

    public void deleteAward(String name) {
        //
        // awardsRepository.deleteByName(name)
        return;
    }
}

