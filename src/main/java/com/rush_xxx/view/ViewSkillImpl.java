package com.rush_xxx.view;

import com.rush_xxx.model.Skill;
import com.rush_xxx.repository.JsonSkillRepositoryImpl;

import java.util.List;
import java.util.Scanner;

public class ViewSkillImpl extends BaseView{

    Scanner sc = new Scanner(System.in);

    @Override
    void create() {
        System.out.println("Input skill name: ");
        String name = sc.next();
        JsonSkillRepositoryImpl jsonSkillRepository = new JsonSkillRepositoryImpl();
        jsonSkillRepository.create(name);
    }

    @Override
    void read() {
        JsonSkillRepositoryImpl jsonSkillRepository = new JsonSkillRepositoryImpl();
        System.out.print("input skill id: ");
        Long id = (long) sc.nextInt();
        try {
            Skill skill = jsonSkillRepository.getById(id);
            System.out.println("Skill name : " + skill.getName());
        }catch (NullPointerException e){
            System.out.println("there is no skill with " + id + " id");
        }
    }

    @Override
    void update() {
        JsonSkillRepositoryImpl jsonSkillRepository = new JsonSkillRepositoryImpl();

        System.out.print("input skill id to update: ");
        Long id = (long) sc.nextInt();

        try{
            jsonSkillRepository.getById(id);
            System.out.println("current skill name is: " + jsonSkillRepository.getById(id).getName());
            System.out.print("input new skill name: ");
            String name = sc.next();
            jsonSkillRepository.update(id, name);
        }catch (NullPointerException e){
            System.out.println("there is no skill with " + id + " id");
        }
    }

    @Override
    void delete() {
        System.out.println("Input skill id for delete: ");
        Long id = (long) sc.nextInt();

        JsonSkillRepositoryImpl jsonSkillRepository = new JsonSkillRepositoryImpl();
        jsonSkillRepository.remove(id);
    }

    @Override
    void readAll() {
        JsonSkillRepositoryImpl jsonSkillRepository = new JsonSkillRepositoryImpl();
        List<Skill> skills = jsonSkillRepository.viewAll();

        System.out.println("----------------------------------------");
        // выводим все элементы кроме первого
        for (int i = 1; i < skills.size(); i++){
            System.out.println(skills.get(i).getId() + " - " + skills.get(i).getName());
        }
        System.out.println("----------------------------------------");
    }
}
