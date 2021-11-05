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
        Skill skill = jsonSkillRepository.getById(id);
        System.out.println("Skill name : " + skill.getName());
    }

    @Override
    void update() {

    }

    @Override
    void delete() {
        System.out.println("Input skill id for delete: ");
        Long id = Long.valueOf(sc.nextInt());
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
