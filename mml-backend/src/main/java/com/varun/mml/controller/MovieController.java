package com.varun.mml.controller;

import com.varun.mml.model.Movie;
import com.varun.mml.model.MovieWrapper;
import com.varun.mml.movie.MovieRequest;
import com.varun.mml.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("movie")
public class MovieController {

    private final MovieService movieService;

    @CrossOrigin(origins = "*")
    @GetMapping("allMovies")
    public ResponseEntity<List<MovieWrapper>> getAllMovies(){
        return movieService.getAllMovies();
    }
    
    @GetMapping("allMovies/desc")
    public ResponseEntity<List<MovieWrapper>> getAllMoviesDsc(){
        return movieService.getAllMoviesDesc();
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id){
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

    @PostMapping
    public ResponseEntity<Integer> addMovie(
            @RequestBody @Valid MovieRequest request,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(movieService.save(request, connectedUser));
    }

    @GetMapping("/owner")
    public ResponseEntity<List<Movie>> getAllMoviesByOwner(
            Authentication connectedUser
    ){
        return movieService.getAllMoviesByOwner(connectedUser);
    }
}