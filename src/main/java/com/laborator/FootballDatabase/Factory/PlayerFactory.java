package com.laborator.FootballDatabase.Factory;

import com.laborator.FootballDatabase.Domain.Players;
public interface PlayerFactory {
    Players createPlayer(int playerID, String name, int age, String nationality, String position, int teamID, int number);
}
