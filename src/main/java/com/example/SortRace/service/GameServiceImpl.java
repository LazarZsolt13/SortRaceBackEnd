package com.example.SortRace.service;

import com.example.SortRace.controller.PlayController;
import com.example.SortRace.helper.mapper.game.SearchGameDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GameServiceImpl implements GameService {

    public int create(){
        return 1;
    }

    public int searchgame(Long id, SearchGameDto searchGameDto){
        return PlayController.getInstance().newPlayerManager(id, searchGameDto.getRoomsize());
    }
}
