package com.example.lecture.repository;

import com.example.lecture.entity.GameMania;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GameManiaRepository {
    static final Logger logger =
            LoggerFactory.getLogger(GameManiaRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(GameMania gameMania) throws Exception {
        logger.info("create()");

        String query = "insert into ItemMania(id, pw, nickname, item, price) values (?, ?, ?, ?, ?)";
        jdbcTemplate.update(query,
                gameMania.getId(), gameMania.getPw(), gameMania.getNickname(),
                gameMania.getItem(), gameMania.getPrice()
        );

    }

    public List<GameMania> list() throws Exception {
        logger.info("list()");
        List<GameMania> results = jdbcTemplate.query(
                "select id, pw, nickname, " +
                        "item, price from ItemMania " +
                        "order by id desc",
                new RowMapper<GameMania>() {
                    @Override
                    public GameMania mapRow(ResultSet rs, int rowNum) throws SQLException {
                        GameMania gameMania = new GameMania();
                        gameMania.setId(rs.getString("id"));
                        gameMania.setPw(rs.getString("pw"));
                        gameMania.setNickname(rs.getString("content"));
                        gameMania.setItem(rs.getString("writer"));
                        gameMania.setPrice(rs.getString("price"));

                        return gameMania;
                    }
                });
        return results;
    }

    public void remove(Integer id) throws Exception {
        logger.info("remove()");

        String query = "delete from ItemMania where id = ?";

        jdbcTemplate.update(query, id);
    }

    public GameMania read(Integer id) throws Exception {
        List<GameMania> results = jdbcTemplate.query(
                "select id, pw, nickname, item, price " +
                        "from ItemMania where id = ?",
                new RowMapper<GameMania>() {
                    @Override
                    public GameMania mapRow(ResultSet rs, int rowNum) throws SQLException {
                        GameMania gameMania = new GameMania();
                        gameMania.setId(rs.getString("id"));
                        gameMania.setPw(rs.getString("pw"));
                        gameMania.setNickname(rs.getString("nickname"));;
                        gameMania.setItem(rs.getString("item"));
                        gameMania.setPrice(rs.getString("price"));

                        return gameMania;
                    }
                }, id
        );

        return results.isEmpty() ? null : results.get(0);
    }

    public void modify(GameMania gameMania) {
        logger.info("modify()");
        // update는 데이터베이스 테이블의 내용을 갱신하는데 사용한다.
        // update 테이블명 set 이후에 고칠 값들 필요하다면 조건이 붙음
        String query = "update ItemMania set nickname = ?, item = ? " +
                "where id = ?";

        jdbcTemplate.update(query, gameMania.getNickname(), gameMania.getItem(),
                gameMania.getId());
    }
}
