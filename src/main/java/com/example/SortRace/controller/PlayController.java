package com.example.SortRace.controller;

import com.example.SortRace.controller.GameModes.RoomController;
import com.example.SortRace.controller.Methods.BubleSortController;
import com.example.SortRace.helper.mapper.game.CompareRequestDTO;
import com.example.SortRace.helper.mapper.game.SwapRequestDTO;

import java.util.ArrayList;

public final class PlayController {
    private static PlayController playController;
    private PlayController() {
    }

    private ArrayList<BaseGameController> games = new ArrayList<>();

    public static PlayController getInstance(){
        if (playController==null) {
            playController = new PlayController();
        }
        return playController;
    }

    public boolean roomIsFull(int id){
        int increment =0 ;
        while (increment<200){
            for (BaseGameController game:this.games) {
                if(game instanceof RoomController){
                    if(game.getThisGameId()==id && ((RoomController) game).getFreeSpace()==0){
                        return true;
                    }
                }

            }
            increment++;
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }

        }
        return false;
    }
    
    public int newPlayerManager(Long id, int roomspace){
        for (BaseGameController game:games) {
                if (game.isInThisRoom(id)) {
                    return game.getThisGameId();
                }
        }

        for (BaseGameController game:games) {
            if(game instanceof RoomController) {
                if ((((RoomController) game).getThisRoomSpace() == roomspace) && (((RoomController) game).getFreeSpace() > 0)) {
                    return ((RoomController) game).newPlayer(id);
                }
            }
        }
        RoomController temp = new RoomController(roomspace);
        temp.newPlayer(id);
        games.add(temp);
        return temp.getThisGameId();
    }
    public int removePlayerManager(Long id){
        int removedPN =0;
        for (BaseGameController game:games) {
            if (game.isInThisRoom(id)) {
                game.removePlayer(id);
                removedPN++;
            }
        }
        return removedPN;
    }
    public void deleteGame(int i){
        games.remove(i);
    }

    public boolean newPlayerAdd(Long id){
        return true;
    }
    public int compareByindex(Long id, CompareRequestDTO compareRequestDTO){
        for (BaseGameController game:games) {
                if (game.isInThisRoom(id)) {
                    return game.getCurrentPlayer(id).CompareByIndex(compareRequestDTO);
                }
        }
        return 0;
    }
    public long swapByIndex(Long id, SwapRequestDTO swapRequestDTO){
        for (BaseGameController game:games) {
            if (game.isInThisRoom(id)) {
                return game.getCurrentPlayer(id).SwapByIndex(swapRequestDTO);
            }
        }
        return -1;
    }
    public int newBubleMethod(Long id){
        for (BaseGameController game:games) {
            if (game.isInThisRoom(id)) {
                return game.getThisGameId();
            }
        }

        BubleSortController temp = new BubleSortController();
        temp.newPlayer(id);
        games.add(temp);
        return temp.getThisGameId();

    }


}
