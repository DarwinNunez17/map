package com.laborator.FootballDatabase.Tests;

import com.laborator.FootballDatabase.Domain.Players;
import com.laborator.FootballDatabase.Factory.PlayerFactory;
import com.laborator.FootballDatabase.StrategyPattern.AgeCategoryStrategy;
import com.laborator.FootballDatabase.StrategyPattern.MiddlePlayerStrategy;
import org.junit.jupiter.api.Test;
import com.laborator.FootballDatabase.Factory.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayersTest {

    @Test
    public void testAgeCategoryStrategy() {
        final PlayerFactory playerFactory = new DefaultPlayerFactory();

        Players youngPlayer = playerFactory.createPlayer(1, "YoungPlayer", 18, "Nationality", "Position", 1, 10);
        assertEquals("Young Player", youngPlayer.getAgeCategory());

        Players middlePlayer = new Players(2, "MiddlePlayer", 25, "Nationality", "Position", 1, 10);
        assertEquals("Middle-Aged Player", middlePlayer.getAgeCategory());

        Players oldPlayer = new Players(3, "OldPlayer", 35, "Nationality", "Position", 1, 10);
        assertEquals("Old-Age Player", oldPlayer.getAgeCategory());

        Players unknownPlayer = new Players(4, "UnknownPlayer", 0, "Nationality", "Position", 1, 10);
        assertEquals("Unknown", unknownPlayer.getAgeCategory());
    }

    @Test
    public void testCustomAgeCategoryStrategy() {
                AgeCategoryStrategy customStrategy = new MiddlePlayerStrategy();
        Players player = new Players(5, "Florinel", 28, "Romania", "Forward", 17, 10);
        player.setAgeCategoryStrategy();
        assertEquals("Middle-Aged Player", player.getAgeCategory());
    }
}
