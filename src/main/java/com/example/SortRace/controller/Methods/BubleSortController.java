package com.example.SortRace.controller.Methods;

import com.example.SortRace.controller.BaseGameController;
import com.example.SortRace.model.PlayerCurrentStage;

import java.util.ArrayList;
import java.util.Objects;

public class BubleSortController extends BaseGameController {
    private int i=0,j=0,iter=0;
    private PlayerCurrentStage player ;
    public BubleSortController(){
        super();
    }
    public int newPlayer(Long id){
        player = new PlayerCurrentStage(id,this.getRandomNumbers());
        return this.getThisGameId();
    }
    public boolean nextStep(int i,int j){
        int testi,testj;
        if((this.j-1)<this.getRandomNumbers().size()){
            testj=this.j+1;
            testi=this.i;
        }else{
            testi=this.i+1;
            testj=testi+1;

        }
        if((i==testi && j==testj)||(j==testi && i==testj)){
            this.i=testi;
            this.j=testj;
            return true;
        }else{
            return false;
        }
    }
    public boolean needSwap(int i, int j){
        if(i>j){
            int aux=i;
            i=j;
            j=aux;
        }
        return this.player.needSwap(i,j);
    }
    @Override
    public boolean isInThisRoom(Long id){
        return Objects.equals(id, this.player.getId());
    }
    @Override
    public PlayerCurrentStage getCurrentPlayer(Long ID){
        return player;
    }
}
