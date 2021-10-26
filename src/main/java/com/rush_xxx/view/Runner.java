package com.rush_xxx.view;

import java.util.Scanner;

public class Runner {

    private Scanner sc = new Scanner(System.in);

    // не нашел нормального метода очистки консоли
    public static void clearConsole(){
        for(int i=0; i<10; i++) System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }

    public void run () {
        clearConsole();
        Menu.printMainMenu();
        String response = sc.next();
        clearConsole();

        // правильно ли здесь использовать if?
        if (response.equals("1")) {
            System.out.println("Your chois is: " + response);
        };
        if (response.equals("2")) {
            System.out.println("Your chois is: " + response);
        };
    }
}
