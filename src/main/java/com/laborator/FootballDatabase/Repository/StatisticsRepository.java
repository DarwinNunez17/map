package com.laborator.FootballDatabase.Repository;
import com.laborator.FootballDatabase.Domain.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface StatisticsRepository extends JpaRepository<Statistics, Long> {
}