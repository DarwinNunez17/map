package com.laborator.FootballDatabase.Controller;

import com.laborator.FootballDatabase.Domain.Statistics;
import com.laborator.FootballDatabase.Services.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {
    private final StatisticsService statisticsService;

    @Autowired
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping
    public List<Statistics> getAllStatistics() {
        return statisticsService.getAllStatistics();
    }

    @GetMapping("/{entityId}")
    public Optional<Statistics> getStatisticsById(@PathVariable int entityId) {
        return statisticsService.getStatisticsById(entityId);
    }

    @PostMapping
    public Statistics saveStatistics(@RequestBody Statistics statistics) {
        return statisticsService.saveStatistics(statistics);
    }

    @DeleteMapping("/{entityId}")
    public void deleteStatisticsById(@PathVariable int entityId) {
        statisticsService.deleteStatisticsById(entityId);
    }
}
