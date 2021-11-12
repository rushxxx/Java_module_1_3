package com.rush_xxx.view;

import com.rush_xxx.controller.DeveloperControllerImpl;

import java.util.Scanner;

public class ViewDeveloperImpl extends BaseView{

    private final DeveloperControllerImpl developerController;

    ViewDeveloperImpl (DeveloperControllerImpl developerController){
        this.developerController = developerController;
    }

    Scanner sc = new Scanner(System.in);

    @Override
    void create() {
        System.out.println("Input developer first name: ");
        String newDeveloperFirstName = sc.next();
        System.out.println("Input developer last name: ");
        String newDeveloperLastName = sc.next();

        System.out.println("Created new developer: " + newDeveloperFirstName + " " + newDeveloperLastName);
        pressEnterKeyToContinue();
    }

    @Override
    void read() {

    }

    @Override
    void update() {

    }

    @Override
    void delete() {

    }

    @Override
    void readAll() {

    }
}
