package com.rush_xxx.model;

import java.util.List;
import java.util.Objects;

public class Team {
    private Long id;
    private String name;
    private List<Developer> developers;

    public Team(Long id, String name, List<Developer> developers) {
        this.id = id;
        this.name = name;
        this.developers = developers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(id, team.id) && Objects.equals(name, team.name) && Objects.equals(developers, team.developers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, developers);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }
}
