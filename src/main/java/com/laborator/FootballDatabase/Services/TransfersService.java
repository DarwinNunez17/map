package com.laborator.FootballDatabase.Services;
import com.laborator.FootballDatabase.Observer.*;
import com.laborator.FootballDatabase.Domain.Team;
import com.laborator.FootballDatabase.Domain.Transfers;
import com.laborator.FootballDatabase.Repository.TransfersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransfersService {
    private TransferObservable transferObservable;
    private final TransfersRepository transfersRepository;

    @Autowired
    public TransfersService(TransfersRepository transfersRepository, TransferObservable transferObservable) {
        this.transfersRepository = transfersRepository;
        this.transferObservable = transferObservable;
    }
    public List<Transfers> getAllTransfers() {
        return transfersRepository.findAll();
    }

    public Transfers getTransferById(int playerID) {
        return transfersRepository.findById((long) playerID).orElse(null);
    }

    public Transfers saveTransfer(Transfers transfers) {
        return transfersRepository.save(transfers);
    }

    public void deleteTransferById(int playerID) {
        transfersRepository.deleteById((long) playerID);
    }

    public void initiateTransfer(int playerID, Team fromTeam, Team toTeam, int transferFee) {
        Transfers transfer = new Transfers(playerID, fromTeam, toTeam, transferFee);

        // Save the transfer to the repository
        transfersRepository.save(transfer);

        // Notify observers
        transferObservable.notifyObservers(transfer);
    }
}
