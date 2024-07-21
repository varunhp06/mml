package com.varun.mml.controller;

import com.varun.mml.model.Tv;
import com.varun.mml.model.TvWrapper;
import com.varun.mml.service.TvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("tv")
public class TvController {
    @Autowired
    TvService tvService;

    @CrossOrigin(origins = "*")
    @GetMapping("allShows")
    public ResponseEntity<List<TvWrapper>> getAllShows(){
        return tvService.getAllShows();
    }

    @GetMapping("allShows/desc")
    public ResponseEntity<List<TvWrapper>> getAllShowsDsc(){
        return tvService.getAllShowsDesc();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("{id}")
    public ResponseEntity<Tv> getShowById(@PathVariable int id){
        return tvService.getShowById(id);
    }

    @GetMapping("allShows/score/asc")
    public ResponseEntity<List<TvWrapper>> getAllShowsByScoreAsc(){
        return tvService.getAllShowsByScoreAsc();
    }

    @GetMapping("allShows/score/desc")
    public ResponseEntity<List<TvWrapper>> getAllShowsByScoreDesc(){
        return tvService.getAllShowsByScoreDesc();
    }

    @GetMapping("allShows/startYear/asc")
    public ResponseEntity<List<TvWrapper>> getAllShowsByStartYearAsc(){
        return tvService.getAllShowsByStartYearAsc();
    }

    @GetMapping("allShows/startYear/desc")
    public ResponseEntity<List<TvWrapper>> getAllShowsByStartYearDesc(){
        return tvService.getAllShowsByStartYearDesc();
    }
}
