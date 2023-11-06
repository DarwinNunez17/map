package Domain;

import Domain.Players;
import Domain.Team;
import java.util.ArrayList;
import java.util.List;

public class Transfers {
    private Players player;
    private Team fromTeam;
    private Team toTeam;
    private int transferFee;

    public Transfers(Players player, Team fromTeam, Team toTeam, int transferFee) {
        this.player = player;
        this.fromTeam = fromTeam;
        this.toTeam = toTeam;
        this.transferFee = transferFee;
    }

    public Players getPlayer() {
        return player;
    }

    public Team getFromTeam() {
        return fromTeam;
    }

    public Team getToTeam() {
        return toTeam;
    }

    public int getTransferFee() {
        return transferFee;
    }

}


