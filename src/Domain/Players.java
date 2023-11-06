package Domain;

public class Players {
    private int playerID;
    private int age;
    private String nationality;
    private String position;
    private int teamID;
    private String name;
    private int number;

    public Players(int playerID, String name, int age, String nationality, String position, int teamID, int number) {
        this.playerID = playerID;
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.position = position;
        this.teamID = teamID;
        this.number = number;
    }

    public int getPlayerID(){
        return playerID;
    }
    public String getName() {
        return name;
    }

    public int getAge(){
        return age;
    }
    public String getNationality(){
        return nationality;
    }
    public String getPosition(){
        return position;
    }
    public int getTeamID(){
        return teamID;
    }
    public int getNumber() {
        return number;
    }
}