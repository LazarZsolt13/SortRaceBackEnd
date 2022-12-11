package com.example.SortRace.controller;

import com.example.SortRace.model.PlayerCurrentStage;

import java.util.ArrayList;
import java.util.Random;

public class RoomController {

    public static int roomId = 0 ;
    private ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
    private ArrayList<PlayerCurrentStage> players = new ArrayList<PlayerCurrentStage>();
    private int thisRoomId;
    public RoomController(){
        Random rand= new Random();
        thisRoomId = roomId;
        roomId++;
        for (int i=0;i<10;i++){
            randomNumbers.add(rand.nextInt(10));
        }
    }

    public ArrayList<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    public int getThisRoomId() {
        return thisRoomId;
    }

    public void newPlayer(Long id){
        PlayerCurrentStage player = new PlayerCurrentStage(id,this.randomNumbers);
        players.add(player);
    }

    //public boolean
}


