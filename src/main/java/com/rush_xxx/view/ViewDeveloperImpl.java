package com.rush_xxx.view;

import com.rush_xxx.controller.DeveloperControllerImpl;
import com.rush_xxx.controller.SkillControllerImpl;
import com.rush_xxx.model.Developer;
import com.rush_xxx.model.Skill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ViewDeveloperImpl extends BaseView{

    private final DeveloperControllerImpl developerController;
    private final SkillControllerImpl skillController;
    private final ViewSkillImpl viewSkill;

    ViewDeveloperImpl(DeveloperControllerImpl developerController, SkillControllerImpl skillController, ViewSkillImpl viewSkill){
        this.developerController = developerController;
        this.skillController = skillController;
        this.viewSkill = viewSkill;
    }

    Scanner sc = new Scanner(System.in);

    @Override
    void create() {
        System.out.println("Input developer first name: ");
        String firstName = sc.next();
        System.out.println("Input developer last name: ");
        String lastName = sc.next();

        viewSkill.readAll();
        System.out.print("Enter id of skill for add to developer :");
        // необходимо сделать чтобы можно было выбирать несколько скиллов
        // типа введите скиллы через запятую
        Long id = sc.nextLong();
        Skill skill = skillController.read(id);

        List<Skill> skills = new ArrayList<>();
        skills.add(skill);

        developerController.create(new Developer(1L, firstName, lastName, skills));
    }

    @Override
    void read() {
        System.out.println("Input Developer id: ");
        Long id = sc.nextLong();
        try{
            Developer developer = developerController.read(id);
            System.out.println("Developer first name: " + developer.getFirstName());
            System.out.println("Developer last name: " + developer.getLastName());
            System.out.print("Skills: ");
            developer.getSkills().forEach(s -> System.out.println(s.getName() + "  "));
            System.out.println();
        }catch(Exception e){
            System.out.println("Incorrect id");
        }

    }

    @Override
    void update() {
        readAll();
        System.out.println("Input developer id for change: ");
        Long id = sc.nextLong();
        if (developerController.readAll().stream().anyMatch(s -> s.getId().equals(id))) {
            System.out.println("Input developer new first name: ");
            String firstName = sc.next();

            System.out.println("Input developer new last name: ");
            String lastName = sc.next();

            viewSkill.readAll();
            System.out.print("Enter id of skill for add to developer: ");
            // сканер nextLine не работает
            String skillsId = sc.nextLine();

            List<Skill> skillList = Arrays.stream(skillsId.split(" "))
                    .map(String::trim)
                    .map(Long::parseLong)
                    .map(skillController::read)
                    .collect(Collectors.toList());

            developerController.update(new Developer(id, firstName, lastName, skillList));
        } else {
            System.out.println("There is no developer with " + id + " id");
        }
    }

    @Override
    void delete() {
        System.out.println("Input developer id to delete: ");
        Long id = sc.nextLong();
        try{
            developerController.delete(id);
        }catch (Exception e){
            System.out.println("There is no " + id + " id, try again");
        }
    }

    @Override
    void readAll() {
        try{
            List<Developer> developers = developerController.readAll();
            System.out.println("___________________________________");
            System.out.println("        *** Developers list ***        ");
            developers.forEach(d -> {
                System.out.print(d.getId() + "  "
                        + d.getFirstName() + "  "
                        + d.getLastName() + "  ");
                d.getSkills().forEach(s -> System.out.print(s.getName() + "  "));
                System.out.println("");
            });

        }catch (Exception e){
            System.out.println("Ops, there are not any developers" + e);
        }
    }
}
