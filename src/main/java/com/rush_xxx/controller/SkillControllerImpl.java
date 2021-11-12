package com.rush_xxx.controller;

import com.rush_xxx.model.Skill;
import com.rush_xxx.repository.JsonSkillRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;

public class SkillControllerImpl implements SkillController{

    JsonSkillRepositoryImpl jsonSkillRepository;

    public SkillControllerImpl(JsonSkillRepositoryImpl jsonSkillRepository){
        this.jsonSkillRepository = jsonSkillRepository;
    }

    @Override
    public void create(String name){
        Long nextId = jsonSkillRepository.getAll().get(0).getId();
        Skill skill = new Skill(nextId, name);
        jsonSkillRepository.save(skill);
    }

    @Override
    public String read(Long id){
        return jsonSkillRepository.getById(id).getName();
    }

    @Override
    public void update(Long id, String name) {
        Skill skill = new Skill(id, name);
    }

    @Override
    public void delete(Long id) {
        jsonSkillRepository.deleteById(id);
    }

    @Override
    public List<Skill> readAll(){
        return jsonSkillRepository.getAll().stream().skip(1).collect(Collectors.toList());
    }

}
