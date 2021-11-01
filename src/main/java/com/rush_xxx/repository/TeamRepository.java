package com.rush_xxx.repository;

import com.rush_xxx.model.Team;

public interface TeamRepository extends GenericRepository<Team, Long>{
    void create (String name);
    void update (Long id, String name);
}
