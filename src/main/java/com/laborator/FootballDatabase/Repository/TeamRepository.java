package com.laborator.FootballDatabase.Repository;
import com.laborator.FootballDatabase.Domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
//    Team findByName(String name);
}

