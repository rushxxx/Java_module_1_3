package com.rush_xxx.controller;

import com.rush_xxx.model.Skill;
import com.rush_xxx.repository.JsonSkillRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;

public class SkillControllerImpl {

    private final JsonSkillRepositoryImpl jsonSkillRepository;

    public SkillControllerImpl(JsonSkillRepositoryImpl jsonSkillRepository){
        this.jsonSkillRepository = jsonSkillRepository;
    }

    public Skill create(Skill skill){
        return jsonSkillRepository.save(skill);
    }

    public Skill read(Long id){
        return jsonSkillRepository.getById(id);
    }

    public Skill update(Skill skill) {
        return jsonSkillRepository.update(skill);
    }

    public void delete(Long id){
        jsonSkillRepository.deleteById(id);
    }

    public List<Skill> readAll(){
        return jsonSkillRepository.getAll().stream()
                .skip(1)
                .collect(Collectors.toList());
    }

}
