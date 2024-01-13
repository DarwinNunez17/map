package com.laborator.FootballDatabase.Controller;

import com.laborator.FootballDatabase.Domain.Stadium;
import com.laborator.FootballDatabase.Services.StadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stadiums")
public class StadiumController {

    private final StadiumService stadiumService;

    @Autowired
    public StadiumController(StadiumService stadiumService) {
        this.stadiumService = stadiumService;
    }

    @GetMapping
    public List<Stadium> getAllStadiums() {
        return stadiumService.getAllStadiums();
    }

    @GetMapping("/{name}")
    public Optional<Stadium> getStadiumByName(@PathVariable String name) {
//        return stadiumService.getStadiumByName(name);
        return null;
    }

    @PostMapping
    public Stadium addStadium(@RequestBody Stadium stadium) {
        return stadiumService.addStadium(stadium);
    }

    @PutMapping("/{name}")
    public void updateStadium(@PathVariable String name, @RequestBody Stadium updatedStadium) {
        stadiumService.updateStadium(name, updatedStadium);
    }

    @DeleteMapping("/{name}")
    public void deleteStadium(@PathVariable String name) {
        stadiumService.deleteStadium(name);
    }
}
