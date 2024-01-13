package com.laborator.FootballDatabase.Repository;
import com.laborator.FootballDatabase.Domain.Competitions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CompetitionsRepository extends JpaRepository<Competitions, Long> {
//    Competitions findCompetitionsByName(String name);
//
//    void deleteByName(String name);
}