package com.laborator.FootballDatabase.Services;

import com.laborator.FootballDatabase.Domain.Referee;
import com.laborator.FootballDatabase.Repository.RefereeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RefereeService {

    private final RefereeRepository refereeRepository;

    @Autowired
    public RefereeService(RefereeRepository refereeRepository) {
        this.refereeRepository = refereeRepository;
    }

    public List<Referee> getAllReferees() {
        return refereeRepository.findAll();
    }

    public Optional<Referee> getRefereeById(int refereeId) {
        return refereeRepository.findById((long) refereeId);
    }

    public Referee addReferee(Referee referee) {
        return refereeRepository.save(referee);
    }

    public void updateReferee(int refereeId, Referee updatedReferee) {
        Optional<Referee> existingReferee = refereeRepository.findById((long) refereeId);
        if (existingReferee.isPresent()) {
            updatedReferee.setRefereeID(refereeId);
            refereeRepository.save(updatedReferee);
        }
        // Handle not found case if needed
    }

    public void deleteReferee(int refereeId) {
        refereeRepository.deleteById((long) refereeId);
    }
}
