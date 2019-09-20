package at.htl.football;

public class Team implements Comparable<Team>{
    private String name;
    private int points = 0;
    private int wins = 0;
    private int draws = 0;
    private int defeats = 0;
    private int goalsShot = 0;
    private int goalsReceived = 0;

    public Team(String name) {
        this.name = name;
    }

    public void addMatch(Match match){

        int guestGoals = match.getGuestGoals();
        int homeGoals = match.getHomeGoals();

        if(match.getHomeName().equals(name)){

            if(guestGoals == homeGoals){
                this.points++;
                this.draws++;
            }else if(guestGoals < homeGoals){
                this.points += 3;
                this.wins++;
            }else {
                this.defeats++;
            }
            this.goalsShot += match.getHomeGoals();
            this.goalsReceived += match.getGuestGoals();

        }else if(match.getGuestName().equals(name)){
            if(guestGoals == homeGoals){
                this.points++;
                this.draws++;
            }else if(guestGoals < homeGoals){
                this.defeats++;
            }else {
                this.points += 3;
                this.wins++;
            }
            this.goalsShot += match.getGuestGoals();
            this.goalsReceived += match.getHomeGoals();
        }

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

    //region Setter
    public void setPoints(int points) {
        this.points = points;
    }
    //endregion


    public int getGoalDifference(){
        return goalsShot - goalsReceived;
    }
    @Override
    public int compareTo(Team o) {
        if (points > o.getPoints()) {
            return 1;
        } else if (points < o.getPoints()) {
            return -1;
        } else {
            return Integer.compare(getGoalDifference(), o.getGoalDifference());
        }
    }
}
