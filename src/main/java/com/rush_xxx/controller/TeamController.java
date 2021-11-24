package com.rush_xxx.controller;

import com.rush_xxx.model.Team;
import com.rush_xxx.repository.JsonTeamRepositoryImpl;

import java.util.List;

public class TeamController {
    JsonTeamRepositoryImpl jsonTeamRepository;

    public TeamController (JsonTeamRepositoryImpl jsonTeamRepository){
        this.jsonTeamRepository = jsonTeamRepository;
    }

    public void create(Team team){
        jsonTeamRepository.save(team);
    }

    public Team read(Long id){
        return jsonTeamRepository.getById(id);
    }

    public void update(Team team){
        jsonTeamRepository.update(team);
    }

    public void delete(Long id) {
        jsonTeamRepository.deleteById(id);
    }

    public List<Team> readAll(){
        return jsonTeamRepository.getAll();
    }
}
