package com.rush_xxx.view;

public class CrudMenu {

    public static void show (String name) {
        System.out.println("Choose an action on " + name);
        System.out.println("1. Create " + name);
        System.out.println("2. View " + name);
        System.out.println("3. Update " + name);
        System.out.println("4. Delete " + name);
        System.out.println("5. View all " + name + "s");
        System.out.println("6. Return");

    }

}
