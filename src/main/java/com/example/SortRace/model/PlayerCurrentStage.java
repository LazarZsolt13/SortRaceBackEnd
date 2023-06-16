package com.example.SortRace.model;

import com.example.SortRace.controller.PlayController;
import com.example.SortRace.helper.mapper.game.CompareRequestDTO;
import com.example.SortRace.helper.mapper.game.SwapRequestDTO;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class PlayerCurrentStage {
    private Long id;
    private ArrayList<Integer> numbers = new ArrayList<Integer>();
    private Instant instant = Instant.now();

    public PlayerCurrentStage(Long id, ArrayList<Integer> randnumbers){
        this.id=id;
        this.numbers.addAll(randnumbers);

    }

    public int CompareByIndex (CompareRequestDTO compareRequestDTO){ // Ha negativ szamot dob akkor a masodik parameteren levo index a nyagyobb
        return numbers.get(compareRequestDTO.geti())-numbers.get(compareRequestDTO.getj());
    }
    public boolean needSwap(int i, int j){
        if(numbers.get(i)>numbers.get(j)){
            return true;
        }
        return false;
    }
    public Long getId(){
        return this.id;
    }
    public void Swap(int i,int j){
        int temp = numbers.get(i);
        numbers.set(i,numbers.get(j));
        numbers.set(j,temp);

    }
    public boolean done(){
        for(int i=0;i<this.numbers.size()-1;i++){
            if (numbers.get(i)>numbers.get(i+1)){
                return false;
            }
        }
        return true;
    }
    public long SwapByIndex(SwapRequestDTO swapRequestDTO){
        if ((swapRequestDTO.geti() == -1) || (swapRequestDTO.getj() == -1)){
            return 1;
        }
        int temp = numbers.get(swapRequestDTO.geti());
        numbers.set(swapRequestDTO.geti(),numbers.get(swapRequestDTO.getj()));
        numbers.set(swapRequestDTO.getj(),temp);
        if (done()){
            return instant.getEpochSecond();
        }
        return 1;
    }

}
