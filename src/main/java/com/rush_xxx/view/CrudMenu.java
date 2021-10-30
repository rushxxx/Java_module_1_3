package com.rush_xxx.view;

public class CrudMenu {

    public static void show (String name) {
        System.out.println("Choose an action on " + name);
        System.out.println("1. Create " + name);
        System.out.println("2. Read " + name);
        System.out.println("3. Update " + name);
        System.out.println("4. Delete " + name);
        System.out.println("5. Return");

    }

}
