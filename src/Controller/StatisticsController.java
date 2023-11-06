package Controller;

import Domain.Statistics;
import Repository.StatisticsRepository;

public class StatisticsController {
    private StatisticsRepository statisticsRepo;

    public StatisticsController() {
        this.statisticsRepo = new StatisticsRepository();
    }

    public void addStatistics(int entityId, int goalsScored, int goalsConceded, int wins, int draws, int losses) {
        Statistics statistics = new Statistics();
        statistics.setGoalsScored(goalsScored);
        statistics.setGoalsConceded(goalsConceded);
        statistics.setWins(wins);
        statistics.setDraws(draws);
        statistics.setLosses(losses);
        statisticsRepo.addStatistics(entityId, statistics);
    }

    public Statistics getStatistics(int entityId) {
        return statisticsRepo.getStatistics(entityId);
    }

    public void updateStatistics(int entityId, int goalsScored, int goalsConceded, int wins, int draws, int losses) {
        Statistics existingStatistics = statisticsRepo.getStatistics(entityId);
        if (existingStatistics != null) {
            existingStatistics.setGoalsScored(goalsScored);
            existingStatistics.setGoalsConceded(goalsConceded);
            existingStatistics.setWins(wins);
            existingStatistics.setDraws(draws);
            existingStatistics.setLosses(losses);
            statisticsRepo.updateStatistics(entityId, existingStatistics);
        }
    }
}
