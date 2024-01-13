package com.laborator.FootballDatabase.StrategyPattern;

public class MiddlePlayerStrategy implements AgeCategoryStrategy {
    @Override
    public String getCategory(int age) {
        if (age >= 24 && age < 30) {
            return "Middle-Aged Player";
        } else {
            return null;
        }
    }
}