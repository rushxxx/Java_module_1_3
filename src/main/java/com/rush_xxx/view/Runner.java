package com.rush_xxx.view;

import com.rush_xxx.controller.DeveloperControllerImpl;
import com.rush_xxx.controller.SkillControllerImpl;
import com.rush_xxx.repository.JsonDeveloperRepositoryImpl;
import com.rush_xxx.repository.JsonSkillRepositoryImpl;

import java.util.Scanner;

public class Runner {

    private final Scanner sc = new Scanner(System.in);

    public void run () {
        while (true) {
            BaseView.clearConsole();
            MainMenu.show();
            String response = sc.next();

            JsonSkillRepositoryImpl skillRepository = new JsonSkillRepositoryImpl();
            SkillControllerImpl skillController = new SkillControllerImpl(skillRepository);
            ViewSkillImpl viewSkillImpl = new ViewSkillImpl(skillController);

            JsonDeveloperRepositoryImpl developerRepository = new JsonDeveloperRepositoryImpl();
            DeveloperControllerImpl developerController = new DeveloperControllerImpl(developerRepository);
            ViewDeveloperImpl viewDeveloper = new ViewDeveloperImpl(developerController, skillController, viewSkillImpl);


            if (response.equals("1")) System.out.println("Your choice is: " + response);
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
