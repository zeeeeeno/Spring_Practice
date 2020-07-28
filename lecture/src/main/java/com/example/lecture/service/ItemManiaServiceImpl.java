package com.example.lecture.service;

import com.example.lecture.entity.Board;
import com.example.lecture.entity.GameMania;
import com.example.lecture.repository.GameManiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemManiaServiceImpl implements ItemManiaService {
    @Autowired
    private GameManiaRepository gameManiaRepository;

    @Override
    public List<GameMania> list() throws Exception {
        return gameManiaRepository.list();
    }

    @Override
    public void register(GameMania gameMania) throws Exception {
        gameManiaRepository.create(gameMania);
    }

    @Override
    public void remove(Integer boardNo) throws Exception {
        gameManiaRepository.remove(boardNo);
    }

    @Override
    public GameMania read(Integer id) throws Exception {
        return gameManiaRepository.read(id);
    }

    @Override
    public void modify(GameMania gameMania) throws Exception {

    }
}
