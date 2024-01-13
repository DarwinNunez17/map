package com.laborator.FootballDatabase.Repository;
import com.laborator.FootballDatabase.Domain.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface StadiumRepository extends JpaRepository<Stadium, Long> {
//    Optional<Stadium> findByName(String name);
//
//    void deleteByName(String name);
}