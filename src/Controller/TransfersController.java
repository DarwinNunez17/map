package Controller;

import Domain.Players;
import Domain.Team;
import Domain.Transfers;
import Repository.TransfersRepository;

import java.util.List;
public class TransfersController {
    private TransfersRepository transferRepo;

    public TransfersController() {
        this.transferRepo = new TransfersRepository();
    }

    public void addTransfer(Players player, Team fromTeam, Team toTeam, int transferFee) {
        Transfers transfer = new Transfers(player, fromTeam, toTeam, transferFee);
        transferRepo.addTransfer(transfer);
    }

    public List<Transfers> getAllTransfers() {
        return transferRepo.getAllTransfers();
    }
}