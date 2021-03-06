package com.rush_xxx.view;

import com.rush_xxx.controller.DeveloperController;
import com.rush_xxx.controller.SkillController;
import com.rush_xxx.model.Developer;
import com.rush_xxx.model.Skill;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ViewDeveloper extends BaseView{

    private final DeveloperController developerController;
    private final SkillController skillController;
    private final ViewSkill viewSkill;

    public ViewDeveloper(DeveloperController developerController, SkillController skillController, ViewSkill viewSkill){
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
        sc.nextLine();

        viewSkill.readAll();
        System.out.print("Enter id skills separated by space for add to developer: ");
        String skillsId = sc.nextLine();

        List<Skill> skills = Arrays.stream(skillsId.split(" "))
                .map(String::trim)
                .map(Long::parseLong)
                .map(skillController::read)
                .collect(Collectors.toList());

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
            developer.getSkills().forEach(s -> System.out.print(s.getName() + "  "));
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

            System.out.println("Input developer new last name:");
            String lastName = sc.next();
            sc.nextLine();

            viewSkill.readAll();
            System.out.print("Enter id of skill for add to developer: ");
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
        readAll();
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
            System.out.println("   *** Developers list *** ");
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
