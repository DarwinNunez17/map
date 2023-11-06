package Repository;

import Domain.Stadium;

import java.util.ArrayList;
import java.util.List;

public class StadiumRepository {
    private List<Stadium> stadiums = new ArrayList<>();

    public void addStadium(Stadium stadium) {
        stadiums.add(stadium);
    }

    public Stadium getStadiumByName(String name) {
        for (Stadium stadium : stadiums) {
            if (stadium.getName().equals(name)) {
                return stadium;
            }
        }
        return null;
    }

    public List<Stadium> getAllStadiums() {
        return stadiums;
    }

    public void updateStadium(Stadium updatedStadium) {
        for (int i = 0; i < stadiums.size(); i++) {
            Stadium stadium = stadiums.get(i);
            if (stadium.getName().equals(updatedStadium.getName())) {
                stadiums.set(i, updatedStadium);
                break;
            }
        }
    }

    public void deleteStadium(String name) {
        stadiums.removeIf(stadium -> stadium.getName().equals(name));
    }
}
