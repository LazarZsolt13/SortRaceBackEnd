package com.example.SortRace.model;

import com.example.SortRace.controller.PlayController;
import com.example.SortRace.helper.mapper.game.CompareRequestDTO;

import java.util.ArrayList;

public class PlayerCurrentStage {
    private Long id;
    private ArrayList<Integer> numbers = new ArrayList<Integer>();

    public PlayerCurrentStage(Long id, ArrayList<Integer> randnumbers){
        this.id=id;
        this.numbers.addAll(randnumbers);
    }

    public int CompareByIndex (CompareRequestDTO compareRequestDTO){ // Ha negativ szamot dob akkor a masodik parameteren levo index a nyagyobb
        return numbers.get(compareRequestDTO.geti())-numbers.get(compareRequestDTO.getj());
    }

    public Long getId(){
        return this.id;
    }
    public void Swap(int i,int j){
        int temp = numbers.get(i);
        numbers.set(i,numbers.get(j));
        numbers.set(j,temp);

    }


}
