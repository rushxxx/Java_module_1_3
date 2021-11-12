package com.rush_xxx.view;

import com.rush_xxx.controller.SkillControllerImpl;
import com.rush_xxx.model.Skill;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ViewSkillImpl extends BaseView{

    private final SkillControllerImpl skillController;

    ViewSkillImpl (SkillControllerImpl skillController){
        this.skillController = skillController;
    }

    Scanner sc = new Scanner(System.in);

    @Override
    void create() {
        System.out.println("Input skill name: ");
        String newSkillName = sc.next();
        skillController.create(newSkillName);

        System.out.println("Created new skill with name " + newSkillName);
        pressEnterKeyToContinue();
    }

    @Override
    void read() {
        System.out.println("Input skill id: ");
        Long id = (long) sc.nextInt();
        try{
            String skillName = skillController.read(id);

            System.out.println("Skill id = " + id + " Skill name = " + skillName);
            pressEnterKeyToContinue();
        }catch (NoSuchElementException e){
            System.out.println("There is no " + id + " id");
            pressEnterKeyToContinue();
        }
    }

    @Override
    void update() {
        System.out.print("input skill id to update: ");
        Long id = (long) sc.nextInt();

        try{
            String oldSkillName = skillController.read(id);
            System.out.println("current skill name is: " + oldSkillName);
            System.out.print("input new skill name: ");
            String newSkillName = sc.next();
            skillController.update(id, newSkillName);

            System.out.println("Skill with name - \"" + oldSkillName + "\" is updated to name - \"" + newSkillName + "\"");
            pressEnterKeyToContinue();
        }catch (Exception e){
            System.out.println("there is no skill with " + id + " id");
            pressEnterKeyToContinue();
        }
    }

    @Override
    void delete() {
        System.out.println("Input skill id: ");
        Long id = (long) sc.nextInt();
        try{
            skillController.delete(id);

            System.out.println("Skill with " + id + " id is deleted");
            pressEnterKeyToContinue();
        }catch (Exception e){
            System.out.println("There is no " + id + " id");
            pressEnterKeyToContinue();
        }
    }

    @Override
    void readAll() {
        List<Skill> skills = skillController.readAll();

        System.out.println("___________________________________");
        System.out.println("        *** Skills list ***        ");

        for (Skill skill : skills) {
            System.out.println("| " + skill.getId() + "  -  " + skill.getName());
        }
        System.out.println("-----------------------------------");
        pressEnterKeyToContinue();
    }

}
