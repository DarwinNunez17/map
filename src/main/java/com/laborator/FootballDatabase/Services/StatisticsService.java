package com.laborator.FootballDatabase.Services;

import com.laborator.FootballDatabase.Domain.Statistics;
import com.laborator.FootballDatabase.Repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatisticsService {
    private final StatisticsRepository statisticsRepository;

    @Autowired
    public StatisticsService(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    public List<Statistics> getAllStatistics() {
        return statisticsRepository.findAll();
    }

    public Optional<Statistics> getStatisticsById(int entityId) {
        return statisticsRepository.findById((long) entityId);
    }

    public Statistics saveStatistics(Statistics statistics) {
        return statisticsRepository.save(statistics);
    }

    public void deleteStatisticsById(int entityId) {
        statisticsRepository.deleteById((long) entityId);
    }
}
