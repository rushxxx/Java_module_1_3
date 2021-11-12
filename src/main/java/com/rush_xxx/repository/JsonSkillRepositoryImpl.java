package com.rush_xxx.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rush_xxx.model.Skill;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JsonSkillRepositoryImpl implements SkillRepository{

    private final static String FILE_NAME = "skills.json";

    @Override
    public Skill getById(Long id) {
        String data = io.readData(FILE_NAME);
        Gson gson = new Gson();
        Type listType = new TypeToken<Collection<Skill>>(){}.getType();
        List<Skill> skills = gson.fromJson(data, listType);

        return skills.stream().filter(s -> s.getId().equals(id)).findFirst().get();
    }

    @Override
    public void deleteById(Long id) {
        String data = io.readData(FILE_NAME);
        Gson gson = new Gson();
        Type listType = new TypeToken<Collection<Skill>>(){}.getType();
        List<Skill> skills = gson.fromJson(data, listType);

        List<Skill> newSkills = skills.stream()
                .skip(1)
                .filter(s -> !s.getId().equals(id))
                .collect(Collectors.toList());

        io.writeData(FILE_NAME, gson.toJson(newSkills));
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

        skills.get(0).setId(skill.getId() + 1);
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
        try {
            skills = skills.stream()
                    .map(s -> s.getId().equals(skill.getId()) ? skill : s)
                    .collect(Collectors.toList());
            io.writeData(FILE_NAME, gson.toJson(skills));
            return skill;
        }catch (Exception e){
            return null;
        }


    }

}
