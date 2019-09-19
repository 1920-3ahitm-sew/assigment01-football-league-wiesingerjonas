package at.htl.football;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {

    Match match;
    Team team;
    League league;

    public static void main(String[] args) {

        League league = new League();

        readFile("bundesliga-1819.csv");

        printTable(league.getTable());
    }

    public static void readFile(String filename){

        List bundesliga1819 = null;

        try {
            Path file = Paths.get(filename);
            bundesliga1819 = Files.readAllLines(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        League league = new League();

        for (int i = 1; i < bundesliga1819.size(); i++) {

            String[] match = bundesliga1819.get(i).toString().split(";");

            league.addMatchResult(new Match(match[1], match[2], Integer.parseInt(match[3]), Integer.parseInt(match[4])));

        }
    }

    private static void printTable(List<Team> teams) {
        System.out.println(teams.size());
    }

}
