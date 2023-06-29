package com.example.SortRace.service;

import com.example.SortRace.controller.PlayController;
import com.example.SortRace.helper.mapper.game.CompareRequestDTO;
import com.example.SortRace.helper.mapper.game.SearchGameDto;
import com.example.SortRace.helper.mapper.game.SwapRequestDTO;
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

    @Override
    public int removeplayer(Long id) {
        return PlayController.getInstance().removePlayerManager(id);
    }

    public int searchBubleMethod(Long id) {
        return PlayController.getInstance().newBubleMethod(id);
    }
    public int nextStep(Long id, CompareRequestDTO compareRequestDTO){
        return PlayController.getInstance().newBubleMethod(id);
    }
    public boolean waitforplayers(int id){
        return PlayController.getInstance().roomIsFull(id);
    }
    public int compareByIndex(Long id, CompareRequestDTO compareRequestDTO){
        return PlayController.getInstance().compareByindex(id,compareRequestDTO);
    }


    public long swapByIndex(Long id, SwapRequestDTO swapRequestDTO) {
        return PlayController.getInstance().swapByIndex(id,swapRequestDTO);
    }
}
