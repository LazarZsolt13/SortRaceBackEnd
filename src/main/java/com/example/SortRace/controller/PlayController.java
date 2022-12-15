package com.example.SortRace.controller;

import java.util.ArrayList;

public final class PlayController {
    private static PlayController playController;
    private PlayController() {
    }

    private ArrayList<RoomController> rooms = new ArrayList<>();

    public static PlayController getInstance(){
        if (playController==null) {
            playController = new PlayController();
        }
        return playController;
    }

    
    public int newPlayerManager(Long id, int roomspace){
        for (RoomController room:rooms) {
            if (room.isInThisRoom(id)){
                return room.getThisRoomId();
            }
        }
        for (RoomController room:rooms) {
            if ((room.getThisRoomSpace() == roomspace) && (room.getFreeSpace()>0)){
                return room.newPlayer(id);
            }
        }
        RoomController temp = new RoomController(roomspace);
        temp.newPlayer(id);
        rooms.add(temp);
        return temp.getThisRoomId();
    }
    public void deleteRoom(int i){
        rooms.remove(i);
    }

    public boolean newPlayerAdd(Long id){
        return true;
    }




}
