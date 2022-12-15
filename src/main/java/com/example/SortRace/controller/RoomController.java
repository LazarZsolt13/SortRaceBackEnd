package com.example.SortRace.controller;

import com.example.SortRace.model.PlayerCurrentStage;

import java.util.ArrayList;
import java.util.Random;

public class RoomController {
    private int space;
    public static int roomId = 0 ;
    private ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
    private ArrayList<PlayerCurrentStage> players = new ArrayList<PlayerCurrentStage>();
    private int thisRoomId;
    public RoomController(int space){
        this.space=space;
        Random rand= new Random();
        thisRoomId = roomId;
        roomId++;
        for (int i=0;i<10;i++){
            randomNumbers.add(rand.nextInt(100));
        }
    }

    public ArrayList<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    public int getThisRoomId() {
        return thisRoomId;
    }
    public int getThisRoomSpace(){return this.space;}

    public int newPlayer(Long id){
        PlayerCurrentStage player = new PlayerCurrentStage(id,this.randomNumbers);
        players.add(player);
        return this.thisRoomId;
    }

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
    //public boolean
}


