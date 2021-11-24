package com.rush_xxx.controller;

import com.rush_xxx.model.Developer;
import com.rush_xxx.repository.JsonDeveloperRepositoryImpl;

import java.util.List;

public class DeveloperControllerImpl {

    JsonDeveloperRepositoryImpl jsonDeveloperRepository;

    public DeveloperControllerImpl (JsonDeveloperRepositoryImpl jsonDeveloperRepository){
        this.jsonDeveloperRepository = jsonDeveloperRepository;
    }

    public void create(Developer developer){
        jsonDeveloperRepository.save(developer);
    }

    public Developer read(Long id){
        return jsonDeveloperRepository.getById(id);
    }

    public void update(Developer developer){
        jsonDeveloperRepository.update(developer);
    }

    public void delete(Long id) {
        jsonDeveloperRepository.deleteById(id);
    }

    public List<Developer> readAll(){
        return jsonDeveloperRepository.getAll();
    }
}
