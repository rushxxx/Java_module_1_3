package com.rush_xxx.view;

import java.util.Scanner;

public class SkillImpl extends BaseView{

    Scanner sc = new Scanner(System.in);

    @Override
    void create() {
        System.out.println("Input skill name: ");
        String name = sc.next();
        System.out.println("Create skill : " + name);
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
}
