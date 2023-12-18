package Controller;

import Domain.Players;
import Domain.Team;
import Domain.Transfers;
import Repository.TransfersRepository;
import Observer.TransferObserver;
import java.util.List;

public class TransfersController implements TransferObserver {
    private TransfersRepository transferRepo;

    public TransfersController() {
        this.transferRepo = new TransfersRepository();
        transferRepo.addObserver(this);
    }

    public void addTransfer(int playerID, Team fromTeam, Team toTeam, int transferFee) {
        Transfers transfer = new Transfers(playerID, fromTeam, toTeam, transferFee);
        transferRepo.addTransfer(transfer);
    }

    public List<Transfers> getAllTransfers() {
        return transferRepo.getAllTransfers();
    }

    @Override
    public void update(Transfers transfer) {
        System.out.println("Controller received update: " + transfer.getPlayerID());
    }
}