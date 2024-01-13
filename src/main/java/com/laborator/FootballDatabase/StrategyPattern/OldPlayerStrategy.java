package com.laborator.FootballDatabase.StrategyPattern;

public class OldPlayerStrategy implements AgeCategoryStrategy {
    @Override
    public String getCategory(int age) {
        if (age > 30) {
            return "Old-Age Player";
        } else {
            return null;
        }
    }
}