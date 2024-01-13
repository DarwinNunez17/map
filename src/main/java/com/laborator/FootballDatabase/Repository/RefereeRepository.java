package com.laborator.FootballDatabase.Repository;
import com.laborator.FootballDatabase.Domain.Referee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RefereeRepository extends JpaRepository<Referee, Long> {
}