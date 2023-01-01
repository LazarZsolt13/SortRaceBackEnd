package com.example.SortRace.service;

import com.example.SortRace.helper.mapper.game.CompareRequestDTO;
import com.example.SortRace.helper.mapper.game.SearchGameDto;

public interface GameService {
    int create();
    /** this is a create method**/
    int searchgame(Long id,SearchGameDto searchGameDto);
    boolean waitforplayers(int id);
    int compareByIndex(Long id, CompareRequestDTO compareRequestDTO);
}
