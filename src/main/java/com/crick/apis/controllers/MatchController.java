package com.crick.apis.controllers;

import com.crick.apis.entities.Match;
import com.crick.apis.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match")
@CrossOrigin("*")
public class MatchController {

    private MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/live")
    public ResponseEntity<List<Match>>getLiveMatches(){
return new ResponseEntity<>(this.matchService.getLiveMatches(), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Match>>getAllMatches(){
        return new ResponseEntity<>(this.matchService.getAllMatches(), HttpStatus.OK);
    }

}
