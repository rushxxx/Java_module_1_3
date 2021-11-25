package com.rush_xxx.view;

import com.rush_xxx.controller.DeveloperController;
import com.rush_xxx.controller.TeamController;
import com.rush_xxx.model.Developer;
import com.rush_xxx.model.Team;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ViewTeam extends BaseView{

    private final TeamController teamController;
    private final DeveloperController developerController;
    private final ViewDeveloper viewDeveloper;


    public ViewTeam(TeamController teamController, DeveloperController developerController, ViewDeveloper viewDeveloper){
        this.teamController = teamController;
        this.developerController = developerController;
        this.viewDeveloper = viewDeveloper;
    }

    Scanner sc = new Scanner(System.in);

    @Override
    void create() {
        System.out.println("Input team name: ");
        String name = sc.next();
        sc.nextLine();

        viewDeveloper.readAll();
        System.out.print("Enter id developers separated by space for add to team: ");
        String developerId = sc.nextLine();

        List<Developer> developers = Arrays.stream(developerId.split(" "))
                .map(String::trim)
                .map(Long::parseLong)
                .map(developerController::read)
                .collect(Collectors.toList());

        teamController.create(new Team(1L, name, developers));
    }

    @Override
    void read() {
        System.out.println("Input team id: ");
        Long id = sc.nextLong();
        try{
            Team team = teamController.read(id);
            System.out.println("Team name: " + team.getName());
            System.out.print("Developers: ");
            team.getDevelopers().forEach(s -> System.out.print(
                    s.getFirstName() + "  " + s.getLastName()));
            System.out.println();
        }catch(Exception e){
            System.out.println("Incorrect id");
        }
    }

    @Override
    void update() {
        readAll();
        System.out.println("Input team id for change: ");
        Long id = sc.nextLong();
        if (teamController.readAll().stream().anyMatch(s -> s.getId().equals(id))) {
            System.out.println("Input team new name:");
            String newName = sc.next();
            sc.nextLine();

            viewDeveloper.readAll();
            System.out.print("Enter id of developers for add to team: ");
            String developersId = sc.nextLine();

            List<Developer> developerList = Arrays.stream(developersId.split(" "))
                    .map(String::trim)
                    .map(Long::parseLong)
                    .map(developerController::read)
                    .collect(Collectors.toList());

            teamController.update(new Team(id, newName, developerList));
        } else {
            System.out.println("There is no team with " + id + " id");
        }
    }

    @Override
    void delete() {
        readAll();
        System.out.println("Input team id to delete: ");
        Long id = sc.nextLong();
        try{
            teamController.delete(id);
        }catch (Exception e){
            System.out.println("There is no " + id + " id, try again");
        }
    }

    @Override
    void readAll() {
        try{
            List<Team> teams = teamController.readAll();
            System.out.println("   *** Teams list *** ");
            teams.forEach(t -> {
                System.out.print(t.getId() + "  " + t.getName() + "  ");
//                t.getDevelopers().forEach(s -> System.out.print(
//                        s.getFirstName() + "  " + s.getLastName()));
                System.out.println("");
            });
        }catch (Exception e){
            System.out.println("Ops, there are not any developers" + e);
        }
    }
}
