package com.laborator.FootballDatabase.Controller;

import com.laborator.FootballDatabase.Domain.Awards;
import com.laborator.FootballDatabase.Services.AwardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/awards")
public class AwardsController {

    @Autowired private final AwardsService awardsService;

    @Autowired
    public AwardsController(AwardsService awardsService) {
        this.awardsService = awardsService;
    }

    @PostMapping
    public void addAward(@RequestBody Awards award) {
        awardsService.addAward(award);
    }

    @GetMapping("/{name}")
    public Awards getAwardByName(@PathVariable String name) {
        return awardsService.getAwardByName(name);
    }

    @GetMapping
    public List<Awards> getAllAwards() {
        return awardsService.getAllAwards();
    }

    @PutMapping("/{name}")
    public void updateAward(@PathVariable String name, @RequestBody Awards updatedAward) {
        awardsService.updateAward(name, updatedAward);
    }

    @DeleteMapping("/{name}")
    public void deleteAward(@PathVariable String name) {
        awardsService.deleteAward(name);
    }
}
