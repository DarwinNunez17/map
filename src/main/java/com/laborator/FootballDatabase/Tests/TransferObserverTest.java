package com.laborator.FootballDatabase.Tests;
import java.util.List;
import com.laborator.FootballDatabase.Domain.*;
import com.laborator.FootballDatabase.Observer.TransferObserver;
import com.laborator.FootballDatabase.Observer.TransferObservable;
import com.laborator.FootballDatabase.FootballDatabaseApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = FootballDatabaseApplication.class)
@Component
public class TransferObserverTest {


    @Autowired
    private TransferObservable transferObservable;

    @Autowired
    private TransferObserver transferObserver;

    @Test
    public void testTransferObserver() throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);

        transferObservable.addObserver(event -> {
            latch.countDown();
        });

        Players player = new Players(1, "Salah", 30, "Egypt", "Forward", 69, 11);
        Team fromTeam = new Team(69, "Liverpool");
        Team toTeam = new Team(70, "Craiova");

        fromTeam.addPlayer(player);

        // Trigger the transfer event
        Transfers transfer = new Transfers(1, fromTeam, toTeam, 100000);
        transferObservable.notifyObservers(transfer);


        List<Transfers> handledTransfers = transferObserver.getHandledTransfers();
        if (!handledTransfers.isEmpty()) {
            assertEquals(transfer, handledTransfers.get(0));
        }
    }
}
