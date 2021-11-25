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
    private final Gson gson = new Gson();
    private final Type listType = new TypeToken<Collection<Skill>>(){}.getType();

    @Override
    public Skill save(Skill skill) {
        List<Skill> skills = gson.fromJson(io.readData(FILE_NAME), listType);

        Long nextId = skills.get(0).getId();
        skills.get(0).setId(nextId  + 1);
        skill.setId(nextId);
        skills.add(skill);
        io.writeData(FILE_NAME, gson.toJson(skills));
        return null;
    }

    @Override
    public Skill getById(Long id) {
        List<Skill> skills = gson.fromJson(io.readData(FILE_NAME), listType);

        return skills.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst().get();
    }

    @Override
    public Skill update(Skill skill) {
        List<Skill> skills = gson.fromJson(io.readData(FILE_NAME), listType);

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

    @Override
    public void deleteById(Long id) {
        List<Skill> skills = gson.fromJson(io.readData(FILE_NAME), listType);

        if (id != 0 && id != skills.get(0).getId()) {
            List<Skill> newSkills = skills.stream()
                    .filter(s -> !s.getId().equals(id))
                    .collect(Collectors.toList());

            io.writeData(FILE_NAME, gson.toJson(newSkills));
        }
    }

    @Override
    public List<Skill> getAll() {
        List<Skill> skills = gson.fromJson(io.readData(FILE_NAME), listType);

        return skills.stream()
                .skip(1)
                .collect(Collectors.toList());
    }

}
