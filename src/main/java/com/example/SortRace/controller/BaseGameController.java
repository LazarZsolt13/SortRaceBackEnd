package com.example.SortRace.controller;

import com.example.SortRace.model.PlayerCurrentStage;

import java.util.ArrayList;
import java.util.Random;

public class BaseGameController {
    public static int gameId = 0 ;
    private ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
    private int thisGameId;

    public BaseGameController(){
        Random rand= new Random();
        thisGameId = gameId;
        gameId++;
        for (int i=0;i<10;i++){
            randomNumbers.add(rand.nextInt(100));
        }
    }
    public ArrayList<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    public int getThisGameId() {
        return thisGameId;
    }

    public boolean isInThisRoom(Long id){
        return false;
    }
    public PlayerCurrentStage getCurrentPlayer(Long ID){
        return null;
    }
}
