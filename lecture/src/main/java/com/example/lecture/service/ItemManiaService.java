package com.example.lecture.service;

import com.example.lecture.entity.GameMania;

import java.util.List;

public interface ItemManiaService {
    public List<GameMania> list() throws Exception;
    public void register(GameMania gameMania) throws Exception;
    public void remove(Integer id) throws Exception;
    public GameMania read(Integer id) throws Exception;
    public void modify(GameMania gameMania) throws Exception;
}
