package Repository;

import Domain.Referee;

import java.util.ArrayList;
import java.util.List;

public class RefereeRepository {
    private List<Referee> referees = new ArrayList<>();

    public void addReferee(Referee referee) {
        referees.add(referee);
    }

    public Referee getRefereeByID(int refereeID) {
        for (Referee referee : referees) {
            if (referee.getRefereeID() == refereeID) {
                return referee;
            }
        }
        return null;
    }

    public List<Referee> getAllReferees() {
        return referees;
    }

    public void updateReferee(Referee updatedReferee) {
        for (int i = 0; i < referees.size(); i++) {
            Referee referee = referees.get(i);
            if (referee.getRefereeID() == updatedReferee.getRefereeID()) {
                referees.set(i, updatedReferee);
                break;
            }
        }
    }

    public void deleteReferee(int refereeID) {
        referees.removeIf(referee -> referee.getRefereeID() == refereeID);
    }
}
