package com.laborator.FootballDatabase.Observer;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import com.laborator.FootballDatabase.Domain.Transfers;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransferObserver implements ApplicationListener<TransferEvent> {

    private final List<Transfers> handledTransfers = new ArrayList<>();

    @Override
    public void onApplicationEvent(TransferEvent event) {
        Transfers transfer = event.getTransfer();
        System.out.println("New transfer received - Player ID: " +
                transfer.getPlayerID() + ", Transfer Fee: " + transfer.getTransferFee());
        handledTransfers.add(transfer);
    }
    public List<Transfers> getHandledTransfers() {
        return handledTransfers;
    }
}
