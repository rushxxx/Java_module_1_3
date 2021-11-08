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

        Skill skill = null;
        for (int i = 1; i < skills.size(); i++){
            if (skills.get(i).getId().equals(id)){
                skill = skills.get(i);
            }
        }
        return skill;
    }

    @Override
    public void deleteById(Long id) {
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
    public List<Skill> getAll() {
        String data = io.readData(FILE_NAME);
        Gson gson = new Gson();
        Type listType = new TypeToken<Collection<Skill>>(){}.getType();
        List<Skill> skills = gson.fromJson(data, listType);

        return skills;
    }


    @Override
    public Skill save(Skill skill) {
        String data = io.readData(FILE_NAME);
        Gson gson = new Gson();
        Type listType = new TypeToken<Collection<Skill>>(){}.getType();
        List<Skill> skills = gson.fromJson(data, listType);

        skills.get(0).setId(skill.getId());
        skills.add(skill);
        io.writeData(FILE_NAME, gson.toJson(skills));
        return null;
    }

    @Override
    public Skill update(Skill skill) {
        String data = io.readData(FILE_NAME);
        Gson gson = new Gson();
        Type listType = new TypeToken<Collection<Skill>>(){}.getType();
        List<Skill> skills = gson.fromJson(data, listType);

        for (int i = 1; i < skills.size(); i++){
            if (skills.get(i).getId().equals(skill.getId())){
                skills.get(i).setName(skill.getName());
            }
        }
        io.writeData(FILE_NAME, gson.toJson(skills));
        return skill;
    }

}
