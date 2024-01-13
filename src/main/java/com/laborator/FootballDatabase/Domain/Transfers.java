package com.laborator.FootballDatabase.Domain;

import com.laborator.FootballDatabase.Observer.TransferObserver;
import com.laborator.FootballDatabase.Observer.TransferObservable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name = "transfers")
public class Transfers extends TransferObservable {
    @Id
    private int playerID;
    private Team fromTeam;
    private Team toTeam;
    private int transferFee;
    private List<TransferObserver> observers = new ArrayList<>();

    public Transfers(int playerID, Team fromTeam, Team toTeam, int transferFee) {
        this.playerID = playerID;
        this.fromTeam = fromTeam;
        this.toTeam = toTeam;
        this.transferFee = transferFee;
    }
    public int getPlayerID() {
        return playerID;
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
    public void addObserver(TransferObserver observer) {
        observers.add(observer);
    }
    public void removeObserver(TransferObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        super.notifyObservers(this);
    }
}
