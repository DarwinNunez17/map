package com.laborator.FootballDatabase.Controller;

import com.laborator.FootballDatabase.Domain.Transfers;
import com.laborator.FootballDatabase.Services.TransfersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transfers")
public class TransfersController {
    private final TransfersService transfersService;

    @Autowired
    public TransfersController(TransfersService transfersService) {
        this.transfersService = transfersService;
    }

    @GetMapping
    public List<Transfers> getAllTransfers() {
        return transfersService.getAllTransfers();
    }

    @GetMapping("/{playerID}")
    public Transfers getTransferById(@PathVariable int playerID) {
        return transfersService.getTransferById(playerID);
    }

    @PostMapping
    public Transfers saveTransfer(@RequestBody Transfers transfers) {
        return transfersService.saveTransfer(transfers);
    }

    @DeleteMapping("/{playerID}")
    public void deleteTransferById(@PathVariable int playerID) {
        transfersService.deleteTransferById(playerID);
    }
}
