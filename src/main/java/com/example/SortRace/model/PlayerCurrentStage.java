package com.example.SortRace.model;

import com.example.SortRace.controller.PlayController;

import java.util.ArrayList;

public class PlayerCurrentStage {
    private Long id;
    private ArrayList<Integer> numbers = new ArrayList<Integer>();

    public PlayerCurrentStage(Long id, ArrayList<Integer> randnumbers){
        this.id=id;
        this.numbers.addAll(randnumbers);
    }

    public int CompareByIndex (int i, int j){ // Ha negativ szamot dob akkor a masodik parameteren levo index a nyagyobb
        return numbers.get(i)-numbers.get(j);
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
