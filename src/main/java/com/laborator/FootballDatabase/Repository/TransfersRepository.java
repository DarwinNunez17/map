package com.laborator.FootballDatabase.Repository;
import com.laborator.FootballDatabase.Domain.Transfers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TransfersRepository extends JpaRepository<Transfers, Long> {
}