package Domain;

public class Manager {
    private int managerID;
    private String name;
    private String nationality;
    private int teamID;
    public Manager(int managerID, String name, String nationality, int teamID) {
        this.managerID = managerID;
        this.name = name;
        this.nationality = nationality;
        this.teamID = teamID;
    }

    public int getManagerID(){
        return managerID;
    }
    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }
    public int getTeamID(){
        return teamID;
    }
}