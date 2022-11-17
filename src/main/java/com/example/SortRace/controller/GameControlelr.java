package com.example.SortRace.controller;

import com.example.SortRace.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.management.ServiceNotFoundException;

@Controller
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/game")
public class GameControlelr {
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
}
