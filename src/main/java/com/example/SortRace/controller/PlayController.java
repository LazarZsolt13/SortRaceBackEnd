package com.example.SortRace.controller;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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

    public boolean roomIsFull(int id){
        int increment =0 ;
        while (increment<200){
            for (RoomController room:this.rooms) {
                if(room.getThisRoomId()==id && room.getFreeSpace()==0){
                    return true;
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
