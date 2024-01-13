package com.laborator.FootballDatabase.Observer;
import org.springframework.context.ApplicationEvent;
import com.laborator.FootballDatabase.Domain.Transfers;

public class TransferEvent extends ApplicationEvent {
    private final Transfers transfer;

    public TransferEvent(Object source, Transfers transfer) {
        super(source);
        this.transfer = transfer;
    }

    public Transfers getTransfer() {
        return transfer;
    }
}
