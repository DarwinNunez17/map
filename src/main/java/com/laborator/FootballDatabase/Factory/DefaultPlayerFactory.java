package com.laborator.FootballDatabase.Factory;
import com.laborator.FootballDatabase.Domain.Players;

public class DefaultPlayerFactory implements PlayerFactory {
    @Override
    public Players createPlayer(int playerID, String name, int age, String nationality, String position, int teamID, int number) {
        return new Players(playerID, name, age, nationality, position, teamID, number);
    }
}
