package com.rush_xxx.view;

import java.util.Scanner;

public abstract class BaseView {
    abstract void create();
    abstract void read();
    abstract void update();
    abstract void delete();
    abstract void readAll();

    private final Scanner sc = new Scanner(System.in);

    public static void clearConsole(){
        // не нашел нормального метода очистки консоли
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }

    public void pressEnterKeyToContinue(){
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
        }
        catch(Exception e)
        {}
    }

    void showMenu(String menuName) {
        while (true) {
            BaseView.clearConsole();
            CrudMenu.show(menuName);
            String response = sc.next();
            BaseView.clearConsole();

            if (response.equals("1")) {
                create();
            }

            if (response.equals("2")) {
                read();
            }

            if (response.equals("3")) {
                update();
            }

            if (response.equals("4")) {
                delete();
            }

            if (response.equals("5")) {
                readAll();
            }

            if (response.equals("6")) break;

            pressEnterKeyToContinue();

        }
    }
}
