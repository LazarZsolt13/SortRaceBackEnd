package com.example.SortRace.service;

import com.example.SortRace.helper.mapper.game.CompareRequestDTO;
import com.example.SortRace.helper.mapper.game.SearchGameDto;
import com.example.SortRace.helper.mapper.game.SwapRequestDTO;

public interface GameService {
    int create();
    /** this is a create method**/
    int searchgame(Long id,SearchGameDto searchGameDto);
    int removeplayer(Long id);
    int searchBubleMethod(Long id);
    boolean waitforplayers(int id);
    int compareByIndex(Long id, CompareRequestDTO compareRequestDTO);
    long swapByIndex(Long id, SwapRequestDTO swapRequestDTO);
}
