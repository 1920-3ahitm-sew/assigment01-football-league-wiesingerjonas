package at.htl.football;

public class Team {
    String name;
    int points;
    int wins;
    int draws;
    int defeats;
    int goalsShot;
    int goalsReceived;

    public Team(String name) {
        this.name = name;
    }

    public void addMatch(Match match){
        return;
    }

    //region Getter
    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public int getGoalsShot() {
        return goalsShot;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }

    //endregion

    public int getGoalDifference(){
        return -1;
    }
    public int copareTo(Team team){
        return -1;
    }
}
