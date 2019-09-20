package at.htl.football;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    Match match;
    Team team;

    public static void main(String[] args) {

        League league = new League();

        league = readFile("bundesliga-1819.csv", league);

        printTable(league.getTable());
    }

    public static League readFile(String filename, League league){

        List bundesliga1819 = null;

        try {
            Path file = Paths.get(filename);
            bundesliga1819 = Files.readAllLines(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 1; i < bundesliga1819.size(); i++) {

            String[] match = bundesliga1819.get(i).toString().split(";");

            league.addMatchResult(new Match(match[1], match[2], Integer.parseInt(match[3]), Integer.parseInt(match[4])));

        }

        return league;
    }

    private static void printTable(List<Team> teams) {

        System.out.printf("%-20s%5s%5s%5s%5s%5s%5s%5s%n", "Team", "Pts", 'W', 'D', 'L', "GF", "GA", "GD");

        for (Team team : teams) {
            System.out.printf("%-20s%5d%5d%5d%5d%5d%5d%5d%n", team.getName(), team.getPoints(), team.getWins(), team.getDraws(), team.getDefeats(),
                    team.getGoalsShot(), team.getGoalsReceived(), team.getGoalDifference());
        }

        System.out.println();
        System.out.println("Pts...Points, W...Won, D...Drawn, L...Lost\n" +
                "GF...Goals for, GA...Goals against, GD...Goal difference");
    }

}
