package com.laborator.FootballDatabase.Repository;
import com.laborator.FootballDatabase.Domain.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface MatchRepository extends JpaRepository<Match, Long> {
}