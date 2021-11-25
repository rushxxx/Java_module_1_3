package com.rush_xxx.view;

import com.rush_xxx.controller.SkillController;
import com.rush_xxx.model.Skill;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ViewSkill extends BaseView{

    private final SkillController skillController;

    ViewSkill(SkillController skillController){
        this.skillController = skillController;
    }

    Scanner sc = new Scanner(System.in);

    @Override
    void create() {
        System.out.println("Input skill name: ");
        skillController.create(new Skill(0L, sc.next()));
    }

    @Override
    void read() {
        System.out.println("Input skill id: ");
        Long id = (long) sc.nextInt();
        try{
            String skillName = skillController.read(id).getName();

            System.out.println("Skill id = " + id + " Skill name = " + skillName);
        }catch (NoSuchElementException e){
            System.out.println("There is no " + id + " id");
        }
    }

    @Override
    void update() {
        readAll();
        System.out.print("input skill id to update: ");
        Long id = (long) sc.nextInt();

        try{
            String oldSkillName = skillController.read(id).getName();
            System.out.println("current skill name is: " + oldSkillName);
            System.out.print("input new skill name: ");
            String newSkillName = sc.next();
            skillController.update(new Skill(id, newSkillName));
        }catch (Exception e){
            System.out.println("there is no skill with " + id + " id");
        }
    }

    @Override
    void delete() {
        readAll();
        System.out.println("Input skill id: ");
        Long id = (long) sc.nextInt();
        try{
            skillController.delete(id);
        }catch (Exception e){
            System.out.println("There is no " + id + " id");
        }
    }

    @Override
    void readAll() {
        List<Skill> skills = skillController.readAll();
        System.out.println("   *** Skills list *** ");
        for (Skill skill : skills) {
            System.out.println(skill.getId() + " - " + skill.getName());
        }
    }

}
