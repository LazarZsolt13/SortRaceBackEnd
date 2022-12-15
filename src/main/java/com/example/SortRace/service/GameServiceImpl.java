package com.example.SortRace.service;

import com.example.SortRace.controller.PlayController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GameServiceImpl implements GameService {

    private final PlayController theController = PlayController.getInstance();
    public int create(){
        return 1;
    }

    public int searchgame(Long id,int roomsize){
        return theController.newPlayerManager(id,roomsize);
    }
}
