package com.rush_xxx.repository;

import com.rush_xxx.model.Skill;

public interface SkillRepository extends GenericRepository<Skill, Long> {

    void create (String name);
    void update (Long id, String name);
}
