package com.rush_xxx.view;

import com.rush_xxx.controller.DeveloperController;
import com.rush_xxx.controller.SkillController;
import com.rush_xxx.controller.TeamController;
import com.rush_xxx.repository.JsonDeveloperRepositoryImpl;
import com.rush_xxx.repository.JsonSkillRepositoryImpl;
import com.rush_xxx.repository.JsonTeamRepositoryImpl;

import java.util.Scanner;

public class Runner {

    private final Scanner sc = new Scanner(System.in);

    public void run () {
        while (true) {
            BaseView.clearConsole();
            MainMenu.show();
            String response = sc.next();

            JsonSkillRepositoryImpl skillRepository = new JsonSkillRepositoryImpl();
            SkillController skillController = new SkillController(skillRepository);
            ViewSkillImpl viewSkillImpl = new ViewSkillImpl(skillController);

            JsonDeveloperRepositoryImpl developerRepository = new JsonDeveloperRepositoryImpl();
            DeveloperController developerController = new DeveloperController(developerRepository);
            ViewDeveloperImpl viewDeveloper = new ViewDeveloperImpl(developerController, skillController, viewSkillImpl);

            JsonTeamRepositoryImpl teamRepository = new JsonTeamRepositoryImpl();
            TeamController teamController = new TeamController(teamRepository);
            ViewTeamImpl viewTeam = new ViewTeamImpl(teamController, developerController, viewDeveloper);


            if (response.equals("1")) viewTeam.showMenu("team");
            if (response.equals("2")) viewDeveloper.showMenu("developer");
            if (response.equals("3")) viewSkillImpl.showMenu("skill");
            if (response.equals("4")){
                break;
            }else{
                System.out.println("Please enter correct menu item");
            };
        }
        sc.close();
    }
}
