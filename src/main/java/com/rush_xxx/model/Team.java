package com.rush_xxx.model;

import java.util.List;
import java.util.Objects;

public class Team {
    private final int id;
    private final String name;
    List<Developer> developers;

    public Team(int id, String name, List<Developer> developers) {
        this.id = id;
        this.name = name;
        this.developers = developers;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public List<Developer> getDevelopers() {
        return developers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id == team.id && name.equals(team.name) && developers.equals(team.developers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, developers);
    }
}
