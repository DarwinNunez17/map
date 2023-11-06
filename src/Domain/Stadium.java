package Domain;

public class Stadium {
    private String name;
    private String location;
    private Team team;

    public Stadium(String name, String location, Team team) {
        this.name = name;
        this.location = location;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Team getTeam() {
        return team;
    }
}