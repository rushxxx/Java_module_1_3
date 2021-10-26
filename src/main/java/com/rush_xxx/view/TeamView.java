package com.rush_xxx.view;

import com.rush_xxx.model.Developer;
import com.rush_xxx.model.Team;

public class TeamView {

    public static void printTeamDetails(Team team) {
        System.out.println("_________________________________________________________________");
        System.out.print("| Team id: " + team.getId() + "  |  Team name: " + team.getName() + "  |  Team Developers: ");

        for (Developer developer : team.getDevelopers()) {
            System.out.print(developer.getFirstName() + ", ");
        }
        System.out.println("");
    }
}
