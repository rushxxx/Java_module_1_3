package com.rush_xxx.view;

import java.util.Scanner;

public class Runner {

    private final Scanner sc = new Scanner(System.in);

    public void run () {
        while (true) {
            BaseView.clearConsole();
            MainMenu.show();
            String response = sc.next();

            TeamImpl teamImpl = new TeamImpl();
            SkillImpl skillImpl = new SkillImpl();

            // правильно ли здесь использовать if?
            if (response.equals("1")) teamImpl.show("team");
            if (response.equals("2")) System.out.println("Your choice is: " + response);
            if (response.equals("3")) skillImpl.show("skill");
            if (response.equals("4")) break;
        }
        sc.close();
    }
}
