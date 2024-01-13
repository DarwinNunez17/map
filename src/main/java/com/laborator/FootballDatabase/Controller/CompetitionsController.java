package com.laborator.FootballDatabase.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.laborator.FootballDatabase.Domain.Competitions;
import com.laborator.FootballDatabase.Services.CompetitionsService;
import java.util.List;

@RestController
@RequestMapping("/competitions")
public class CompetitionsController {
    private final CompetitionsService competitionsService;
    @Autowired
    public CompetitionsController(CompetitionsService competitionsService) {
        this.competitionsService = competitionsService;
    }

    @GetMapping
    public List<Competitions> getAllCompetitions() {
        return competitionsService.getAllCompetitions();
    }

    @GetMapping("/{name}")
    public Competitions getCompetitionByName(@PathVariable String name) {
//        return competitionsService.getCompetitionByName(name);
        return null;
    }

    @PostMapping
    public void addCompetition(@RequestBody Competitions competition) {
        competitionsService.addCompetition(competition);
    }

    @PutMapping("/{name}")
    public void updateCompetition(@PathVariable String name, @RequestBody Competitions updatedCompetition) {
        competitionsService.updateCompetition(name, updatedCompetition);
    }

    @DeleteMapping("/{name}")
    public void deleteCompetition(@PathVariable String name) {
        competitionsService.deleteCompetition(name);
    }
}
