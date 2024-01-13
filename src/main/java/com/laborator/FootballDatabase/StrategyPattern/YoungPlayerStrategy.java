package com.laborator.FootballDatabase.StrategyPattern;

public class YoungPlayerStrategy implements AgeCategoryStrategy {
    @Override
    public String getCategory(int age) {
        if (age < 23) {
            return "Young Player";
        } else {
            return null;
        }
    }
}
