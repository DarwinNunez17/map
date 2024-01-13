package com.laborator.FootballDatabase.Repository;

import com.laborator.FootballDatabase.Domain.Awards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface AwardsRepository extends JpaRepository<Awards, String> {
//    Awards findByName(String name);
//    void deleteByName(String name);
}