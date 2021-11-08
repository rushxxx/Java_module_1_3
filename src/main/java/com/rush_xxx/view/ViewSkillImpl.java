package com.rush_xxx.view;

import com.rush_xxx.controller.SkillControllerImpl;
import com.rush_xxx.model.Skill;

import java.util.List;
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
        pressAnyKeyToContinue();
    }

    @Override
    void read() {
        System.out.println("Input skill id: ");
        Long id = (long) sc.nextInt();
        try{
            String skillName = skillController.read(id);

            System.out.println("Skill id = " + id + " Skill name = " + skillName);
            pressAnyKeyToContinue();
        }catch (Exception e){
            System.out.println("There is no " + id + " id");
            pressAnyKeyToContinue();
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
            pressAnyKeyToContinue();
        }catch (NullPointerException e){
            System.out.println("there is no skill with " + id + " id");
            pressAnyKeyToContinue();
        }
    }

    @Override
    void delete() {
        System.out.println("Input skill id: ");
        Long id = (long) sc.nextInt();
        try{
            skillController.delete(id);

            System.out.println("Skill with " + id + " id is deleted");
            pressAnyKeyToContinue();
        }catch (Exception e){
            System.out.println("There is no " + id + " id");
            pressAnyKeyToContinue();
        }
    }

    @Override
    void readAll() {
        List<Skill> skills = skillController.readAll();

        System.out.println("___________________________________");
        System.out.println("        *** Skills list ***        ");

        for (int i = 1; i < skills.size(); i++){
            System.out.println("| " + skills.get(i).getId() + "  -  " + skills.get(i).getName());
        }
        System.out.println("-----------------------------------");
        pressAnyKeyToContinue();
    }

}
