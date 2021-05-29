package com.valid.jdbc;

import com.valid.jdbc.dao.ActorDao;
import com.valid.jdbc.entity.Actor;

import java.util.List;

public class TestDao {
    public static void main(String[] args) {
        ActorDao actorDao = new ActorDao();

        // 查询
        List<Actor> actors = actorDao.queryList("SELECT * FROM actor WHERE id > ?", Actor.class, 1);
        System.out.println(actors);
    }
}
