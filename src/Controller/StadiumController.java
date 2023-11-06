package Controller;

import Domain.Stadium;
import Domain.Team;
import Repository.StadiumRepository;

import java.util.List;
public class StadiumController {
    private StadiumRepository stadiumRepo;

    public StadiumController() {
        this.stadiumRepo = new StadiumRepository(); // Initialize the repository
    }

    public void addStadium(String name, String location, Team team) {
        Stadium stadium = new Stadium(name, location, team);
        stadiumRepo.addStadium(stadium);
    }

    public Stadium getStadiumByName(String name) {
        return stadiumRepo.getStadiumByName(name);
    }

    public List<Stadium> getAllStadiums() {
        return stadiumRepo.getAllStadiums();
    }

    public void updateStadium(String name, String location, Team team) {
        Stadium existingStadium = stadiumRepo.getStadiumByName(name);
        if (existingStadium != null) {
            Stadium updatedStadium = new Stadium(name, location, team);
            stadiumRepo.updateStadium(updatedStadium);
        }
    }

    public void deleteStadium(String name) {
        stadiumRepo.deleteStadium(name);
    }
}