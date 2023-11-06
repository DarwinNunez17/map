package Repository;

import Domain.Awards;

import java.util.ArrayList;
import java.util.List;

public class AwardsRepository {
    private List<Awards> awardsList = new ArrayList<>();

    public void addAward(Awards award) {
        awardsList.add(award);
    }

    public Awards getAwardByName(String name) {
        for (Awards award : awardsList) {
            if (award.getName().equals(name)) {
                return award;
            }
        }
        return null;
    }

    public List<Awards> getAllAwards() {
        return awardsList;
    }

    public void updateAward(Awards updatedAward) {
        for (int i = 0; i < awardsList.size(); i++) {
            Awards award = awardsList.get(i);
            if (award.getName().equals(updatedAward.getName())) {
                awardsList.set(i, updatedAward);
                break;
            }
        }
    }

    public void deleteAward(String name) {
        awardsList.removeIf(award -> award.getName().equals(name));
    }
}
