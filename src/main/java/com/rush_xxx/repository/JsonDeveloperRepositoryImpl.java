package com.rush_xxx.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rush_xxx.model.Developer;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JsonDeveloperRepositoryImpl implements DeveloperRepository {

    private static final String FILE_NAME = "developers.json";
    private final Gson gson = new Gson();
    private final Type listType = new TypeToken<Collection<Developer>>(){}.getType();

    @Override
    public Developer save(Developer developer){
        List<Developer> developers = gson.fromJson(io.readData(FILE_NAME), listType);

        Long nextId = developers.get(0).getId();
        developer.setId(nextId);
        developers.get(0).setId(nextId + 1);
        developers.add(developer);
        io.writeData(FILE_NAME, gson.toJson(developers));
        return null;
    }

    @Override
    public Developer getById(Long id){
        List<Developer> developers = gson.fromJson(io.readData(FILE_NAME), listType);

        return developers.stream()
                .skip(1)
                .filter(s -> s.getId().equals(id))
                .findFirst().get();
    }

    @Override
    public Developer update(Developer developer){
        List<Developer> developers = gson.fromJson(io.readData(FILE_NAME), listType);

        try{
            developers = developers.stream()
                    .map(d -> d.getId().equals(developer.getId()) ? developer : d)
                    .collect(Collectors.toList());
            io.writeData(FILE_NAME, gson.toJson(developers));
        }catch (Exception e){
            System.out.println(e);;
        }

        return null;
    }

    @Override
    public void deleteById(Long id) {
        List<Developer> developers = gson.fromJson(io.readData(FILE_NAME), listType);

        if (!id.equals(developers.get(0).getId())) {
            List<Developer> newDevelopers = developers.stream()
                    .filter(d -> !d.getId().equals(id))
                    .collect(Collectors.toList());

            io.writeData(FILE_NAME, gson.toJson(newDevelopers));
        }
    }

    @Override
    public List<Developer> getAll(){
        List<Developer> developers = gson.fromJson(io.readData(FILE_NAME), listType);

        return developers.stream().skip(1).collect(Collectors.toList());
    }
}
