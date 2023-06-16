package com.example.SortRace.controller;

import com.example.SortRace.helper.mapper.game.CompareRequestDTO;
import com.example.SortRace.helper.mapper.game.SearchGameDto;
import com.example.SortRace.helper.mapper.game.SwapRequestDTO;
import com.example.SortRace.service.GameService;
import com.example.SortRace.util.Utility;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/game")
public class GameController {
    private final GameService gameService;
    private final Utility utility;

    @GetMapping("/healthCheck1")
    public ResponseEntity<?> healtCheck1() { return ResponseEntity.ok().build(); }

    @PostMapping("/create")
    public ResponseEntity<?> create(){
        try{
            return ResponseEntity.ok().body(gameService.create());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("hiba");
        }
    }

    @PostMapping("/searchforgame")
    public ResponseEntity<?> searchforgame(@RequestBody SearchGameDto searchGameDto){
        try{
            return ResponseEntity.ok().body(gameService.searchgame(utility.getCurrentUser().getId(), searchGameDto));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/waitforplayers/{id}")
    public ResponseEntity<?> waitforplayers(@PathVariable("id") int id){
        try{
            return ResponseEntity.ok().body(gameService.waitforplayers(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/startBubleMethod/")
    public ResponseEntity<?> startBubleMethod(){
        try{
            return ResponseEntity.ok().body(gameService.searchBubleMethod(utility.getCurrentUser().getId()));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/compareByIndex")
    public ResponseEntity<?> compareByIndex(@RequestBody CompareRequestDTO compareRequestDTO){
        try{
            return ResponseEntity.ok().body(gameService.compareByIndex(utility.getCurrentUser().getId(), compareRequestDTO));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/swapByIndex")
    public ResponseEntity<?> compareByIndex(@RequestBody SwapRequestDTO swapRequestDTO){
        try{
            return ResponseEntity.ok().body(gameService.swapByIndex(utility.getCurrentUser().getId(), swapRequestDTO));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/nextStep")
    public ResponseEntity<?> nextStep(@RequestBody CompareRequestDTO compareRequestDTO){
        try{
            return ResponseEntity.ok().body(gameService.compareByIndex(utility.getCurrentUser().getId(), compareRequestDTO));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
