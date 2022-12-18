package com.example.SortRace.service;

import com.example.SortRace.helper.mapper.game.SearchGameDto;

public interface GameService {
    int create();
    /** this is a create method**/
    int searchgame(Long id,SearchGameDto searchGameDto);
}
