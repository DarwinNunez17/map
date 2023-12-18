package Domain;

import Observer.TransferObserver;
import Observer.TransferObservable;
import java.util.ArrayList;
import java.util.List;

public class Transfers implements TransferObservable {
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

    public Transfers(int playerId, double amount) {
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

    @Override
    public void addObserver(TransferObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(TransferObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Transfers transfer) {
        for (TransferObserver observer : observers) {
            observer.update(transfer);
        }
    }
    
}
