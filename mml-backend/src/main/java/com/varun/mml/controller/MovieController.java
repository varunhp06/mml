package com.varun.mml.controller;

import com.varun.mml.model.MovieWrapper;
import com.varun.mml.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping("allMovies")
    public ResponseEntity<List<MovieWrapper>> getAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("allMovies/desc")
    public ResponseEntity<List<MovieWrapper>> getAllMoviesDsc(){
        return movieService.getAllMoviesDesc();
    }

    @GetMapping("allMovies/{id}")
    public ResponseEntity<MovieWrapper> getMovieById(@PathVariable int id){
        return movieService.getMovieById(id);
    }

    @GetMapping("allMovies/score/asc")
    public ResponseEntity<List<MovieWrapper>> getAllMoviesByScoreAsc(){
        return movieService.getAllMoviesByScoreAsc();
    }

    @GetMapping("allMovies/score/desc")
    public ResponseEntity<List<MovieWrapper>> getAllMoviesByScoreDesc(){
        return movieService.getAllMoviesByScoreDesc();
    }

    @GetMapping("allMovies/year/asc")
    public ResponseEntity<List<MovieWrapper>> getAllMoviesByYearAsc(){
        return movieService.getAllMoviesByYearAsc();
    }

    @GetMapping("allMovies/year/desc")
    public ResponseEntity<List<MovieWrapper>> getAllMoviesByYearDesc(){
        return movieService.getAllMoviesByYearDesc();
    }
}
