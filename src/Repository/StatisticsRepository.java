package Repository;

import Domain.Statistics;

import java.util.HashMap;
import java.util.Map;

public class StatisticsRepository {
    private Map<Integer, Statistics> statisticsMap = new HashMap<>();

    public void addStatistics(int entityId, Statistics statistics) {
        statisticsMap.put(entityId, statistics);
    }

    public Statistics getStatistics(int entityId) {
        return statisticsMap.get(entityId);
    }

    public void updateStatistics(int entityId, Statistics updatedStatistics) {
        if (statisticsMap.containsKey(entityId)) {
            statisticsMap.put(entityId, updatedStatistics);
        }
    }

}
