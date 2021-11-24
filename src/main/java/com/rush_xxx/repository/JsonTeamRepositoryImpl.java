package com.rush_xxx.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rush_xxx.model.Team;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JsonTeamRepositoryImpl implements TeamRepository {

    private final static String FILE_NAME = "teams.json";
    private final Gson gson = new Gson();
    private final Type listType = new TypeToken<Collection<Team>>(){}.getType();

    @Override
    public Team save(Team team) {
        List<Team> teams = gson.fromJson(io.readData(FILE_NAME), listType);

        Long nextId = teams.get(0).getId();
        team.setId(nextId);
        teams.get(0).setId(nextId + 1);
        teams.add(team);
        io.writeData(FILE_NAME, gson.toJson(teams));

        return null;
    }

    @Override
    public Team getById(Long id) {
        List<Team> teams = gson.fromJson(io.readData(FILE_NAME), listType);

        return teams.stream()
                .skip(1)
                .filter(s -> s.getId().equals(id))
                .findFirst().get();
    }

    @Override
    public Team update(Team team) {
        List<Team> teams = gson.fromJson(io.readData(FILE_NAME), listType);

        try{
            teams = teams.stream()
                    .map(t -> t.getId().equals(team.getId()) ? team : t)
                    .collect(Collectors.toList());
            io.writeData(FILE_NAME, gson.toJson(teams));
        }catch (Exception e){
            System.out.println(e);;
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        List<Team> teams = gson.fromJson(io.readData(FILE_NAME), listType);

        if (!id.equals(teams.get(0).getId())) {
            List<Team> newTeam = teams.stream()
                    .filter(t -> !t.getId().equals(id))
                    .collect(Collectors.toList());

            io.writeData(FILE_NAME, gson.toJson(newTeam));
        }
    }

    @Override
    public List<Team> getAll() {
        List<Team> teams = gson.fromJson(io.readData(FILE_NAME), listType);

        return teams.stream().skip(1).collect(Collectors.toList());
    }

}
