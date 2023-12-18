package Controller;

import Domain.Awards;
import Repository.AwardsRepository;
import java.sql.Connection;

import java.util.List;
public class AwardsController {
    private AwardsRepository awardsRepo;

    public AwardsController() {
        this.awardsRepo = new AwardsRepository(); // Initialize the repository
    }

    public void addAward(String name, int year) {
        Awards award = new Awards(name, year);
        awardsRepo.addAward(award);
    }

    public Awards getAwardByName(String name) {
        return awardsRepo.getAwardByName(name);
    }

    public List<Awards> getAllAwards() {
        return awardsRepo.getAllAwards();
    }

    public void updateAward(String name, int newYear) {
        Awards existingAward = awardsRepo.getAwardByName(name);
        if (existingAward != null) {
            Awards updatedAward = new Awards(name, newYear);
            awardsRepo.updateAward(updatedAward);
        }
    }

    public void deleteAward(String name) {
        awardsRepo.deleteAward(name);
    }


    public void displayAllAwards() {
        List<Awards> awards = getAllAwards();
        for (Awards award : awards) {
            System.out.println(award);
        }
    }
}