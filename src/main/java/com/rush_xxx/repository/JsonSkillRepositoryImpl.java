package com.rush_xxx.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rush_xxx.model.Skill;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

public class JsonSkillRepositoryImpl implements SkillRepository{

    private final static String FILE_NAME = "skills.json";

    @Override
    public Skill getById(Long id) {
        String data = io.readData(FILE_NAME);

        Gson gson = new Gson();
        Type listType = new TypeToken<Collection<Skill>>(){}.getType();
        List<Skill> skills = gson.fromJson(data, listType);

        Skill skill = skills.get(Math.toIntExact(id));

        return skill;
    }

    @Override
    public void remove(Long id) {
        String data = io.readData(FILE_NAME);

        Gson gson = new Gson();
        Type listType = new TypeToken<Collection<Skill>>(){}.getType();
        List<Skill> skills = gson.fromJson(data, listType);

        for (int i = 1; i < skills.size(); i++){
            if (skills.get(i).getId().equals(id)){
                skills.remove(i);
                io.writeData(FILE_NAME, gson.toJson(skills));
                break;
            }
        }
    }

    @Override
    public List<Skill> viewAll() {
        String data = io.readData(FILE_NAME);

        Gson gson = new Gson();
        Type listType = new TypeToken<Collection<Skill>>(){}.getType();
        List<Skill> skills = gson.fromJson(data, listType);

        return skills;
    }

    @Override
    public void create(String name) {

        String data = io.readData(FILE_NAME);

        Gson gson = new Gson();
        Type listType = new TypeToken<Collection<Skill>>(){}.getType();
        List<Skill> skills = gson.fromJson(data, listType);

        Long newId = skills.get(0).getId() + 1;// id первого скилла является счетчиком уникальных id
        skills.get(0).setId(newId);
        Skill skill = new Skill(newId, name);
        skills.add(skill);

        io.writeData(FILE_NAME, gson.toJson(skills));
    }

    @Override
    public void update(Long id, String name) {

    }

}
