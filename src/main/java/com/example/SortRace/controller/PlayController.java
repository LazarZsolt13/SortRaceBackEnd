package com.example.SortRace.controller;

import java.util.ArrayList;

public final class PlayController {
    private static PlayController playController;
    private PlayController() {
        if (playController==null) {
            playController = new PlayController();
        }
    }

    private ArrayList<RoomController> rooms = new ArrayList<>();

    public static PlayController getInstance(){
        return playController;
    }

    public void newRoom (){
        RoomController room = new RoomController();
        rooms.add(room);
    }

    public void deleteRoom(int i){
        rooms.remove(i);
    }

    public boolean newPlayerAdd(Long id){
        return true;
    }




}
