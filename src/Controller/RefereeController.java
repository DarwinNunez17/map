package Controller;

import Domain.Referee;
import Repository.RefereeRepository;

import java.util.List;
public class RefereeController {
    private RefereeRepository refereeRepo;

    public RefereeController() {
        this.refereeRepo = new RefereeRepository(); // Initialize the repository
    }

    public void addReferee(int refereeID, String name, String nationality, int competitionID) {
        Referee referee = new Referee(refereeID, name, nationality, competitionID);
        refereeRepo.addReferee(referee);
    }

    public Referee getRefereeByID(int refereeID) {
        return refereeRepo.getRefereeByID(refereeID);
    }

    public List<Referee> getAllReferees() {
        return refereeRepo.getAllReferees();
    }

    public void updateReferee(int refereeID, String name, String nationality, int competitionID) {
        Referee existingReferee = refereeRepo.getRefereeByID(refereeID);
        if (existingReferee != null) {
            Referee updatedReferee = new Referee(refereeID, name, nationality, competitionID);
            refereeRepo.updateReferee(updatedReferee);
        }
    }

    public void deleteReferee(int refereeID) {
        refereeRepo.deleteReferee(refereeID);
    }

}