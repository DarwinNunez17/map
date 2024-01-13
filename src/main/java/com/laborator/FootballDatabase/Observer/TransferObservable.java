package com.laborator.FootballDatabase.Observer;

import com.laborator.FootballDatabase.Domain.Transfers;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransferObservable {
    private final List<ApplicationListener<TransferEvent>> listeners = new ArrayList<>();

    public void addObserver(ApplicationListener<TransferEvent> listener) {
        listeners.add(listener);
    }

    public void removeObserver(ApplicationListener<TransferEvent> listener) {
        listeners.remove(listener);
    }

    public void notifyObservers(Transfers transfer) {
        TransferEvent event = new TransferEvent(this, transfer);
        listeners.forEach(listener -> listener.onApplicationEvent(event));
    }
}
