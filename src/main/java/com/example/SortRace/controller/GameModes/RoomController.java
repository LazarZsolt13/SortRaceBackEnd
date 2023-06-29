package com.example.SortRace.controller.GameModes;

import com.example.SortRace.controller.BaseGameController;
import com.example.SortRace.model.PlayerCurrentStage;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class RoomController extends BaseGameController {
    private int space;
    private ArrayList<PlayerCurrentStage> players = new ArrayList<PlayerCurrentStage>();
    public RoomController(int space){
        super();
        this.space=space;

    }

    public int getThisRoomSpace(){return this.space;}

    public int newPlayer(Long id){
        PlayerCurrentStage player = new PlayerCurrentStage(id,this.getRandomNumbers());
        players.add(player);
        return this.getThisGameId();
    }
    @Override
    public boolean isInThisRoom(Long id){
        for (PlayerCurrentStage player:this.players) {
            if(id==player.getId()){
                return true;
            }
        }
        return false;
    }
    public int getFreeSpace(){
        return this.space- players.size();
    }
    @Override
    public PlayerCurrentStage getCurrentPlayer(Long ID){
        for (PlayerCurrentStage player: players )
        {
            if(player.getId() == ID){
                return player;
            }
        }
        return null;
    }
    @Override
    public void removePlayer(Long id){
        PlayerCurrentStage current = null;
        for (PlayerCurrentStage player:this.players) {
            if(Objects.equals(id, player.getId())){
                current = player;
            }
        }
        players.remove(current);

    }
}


