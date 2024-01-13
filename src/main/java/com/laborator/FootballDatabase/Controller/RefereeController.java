package com.laborator.FootballDatabase.Controller;

import com.laborator.FootballDatabase.Domain.Referee;
import com.laborator.FootballDatabase.Services.RefereeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/referees")
public class RefereeController {

    private final RefereeService refereeService;

    @Autowired
    public RefereeController(RefereeService refereeService) {
        this.refereeService = refereeService;
    }

    @GetMapping
    public List<Referee> getAllReferees() {
        return refereeService.getAllReferees();
    }

    @GetMapping("/{id}")
    public Optional<Referee> getRefereeById(@PathVariable int id) {
        return refereeService.getRefereeById(id);
    }

    @PostMapping
    public Referee addReferee(@RequestBody Referee referee) {
        return refereeService.addReferee(referee);
    }

    @PutMapping("/{id}")
    public void updateReferee(@PathVariable int id, @RequestBody Referee updatedReferee) {
        refereeService.updateReferee(id, updatedReferee);
    }

    @DeleteMapping("/{id}")
    public void deleteReferee(@PathVariable int id) {
        refereeService.deleteReferee(id);
    }
}
