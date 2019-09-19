package at.htl.football;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League {

    private List<Team> teams = new ArrayList<>();

    public void addMatchResult(Match match){
        findOrCreateTeam(match.getHomeName()).addMatch(match);
        findOrCreateTeam(match.getGuestName()).addMatch(match);
    }

    private Team findOrCreateTeam(String teamName){

        for (Team team : teams) {
            if (team.getName().equals(teamName)) {
                return team;
            }
        }

        Team cb = new Team(teamName);
        teams.add(cb);
        return cb;
    }

    public List<Team> getTable(){
        teams.sort(Collections.reverseOrder());
        return teams;
    }

}
