package com.example.SortRace.controller;

import com.example.SortRace.service.GameService;
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


    @GetMapping("/healthCheck")
    public ResponseEntity<?> healtCheck() { return ResponseEntity.ok().build(); }

    @PostMapping("/create")
    public ResponseEntity<?> create(){
        try{
            return ResponseEntity.ok().body(gameService.create());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("hiba");
        }
    }

    @PostMapping("/searchforgame")
    public ResponseEntity<?> searchforgame(@RequestBody Long id, int roomspace){
        try{
            return ResponseEntity.ok().body(gameService.searchgame(id,roomspace));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
