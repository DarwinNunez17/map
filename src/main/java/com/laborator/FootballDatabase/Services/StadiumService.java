package com.laborator.FootballDatabase.Services;

import com.laborator.FootballDatabase.Domain.Stadium;
import com.laborator.FootballDatabase.Repository.StadiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StadiumService {

    private final StadiumRepository stadiumRepository;

    @Autowired
    public StadiumService(StadiumRepository stadiumRepository) {
        this.stadiumRepository = stadiumRepository;
    }

    public List<Stadium> getAllStadiums() {
        return stadiumRepository.findAll();
    }

//    public Optional<Stadium> getStadiumByName(String name) {
//        ?return stadiumRepository.findByName(name);
//    }

    public Stadium addStadium(Stadium stadium) {
        return stadiumRepository.save(stadium);
    }

    public void updateStadium(String name, Stadium updatedStadium) {
//       // Optional<Stadium> existingStadium = stadiumRepository.findById(Long id)
//        if (existingStadium.isPresent()) {
//            updatedStadium.setName(name);
//            stadiumRepository.save(updatedStadium);
//        }
//        // Handle not found case if needed
    }

    public void deleteStadium(String name) {
//        stadiumRepository.deleteByName(name);
        return;
    }
}
