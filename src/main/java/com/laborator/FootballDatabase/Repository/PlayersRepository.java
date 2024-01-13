package com.laborator.FootballDatabase.Repository;
import com.laborator.FootballDatabase.Domain.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PlayersRepository extends JpaRepository<Players, Long> {
}