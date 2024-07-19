package com.varun.mml.service;

import com.varun.mml.dao.MovieDao;
import com.varun.mml.model.Movie;
import com.varun.mml.model.MovieWrapper;
import com.varun.mml.dao.MovieWrapperDao;
import com.varun.mml.model.TvWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieWrapperDao movieWrapperDao;
    @Autowired
    MovieDao movieDao;

    public ResponseEntity<List<MovieWrapper>> getAllMovies() {
        try{
            return new ResponseEntity<>(movieWrapperDao.findAllByOrderByRankAsc(), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<MovieWrapper>> getAllMoviesDesc() {
        try{
            return new ResponseEntity<>(movieWrapperDao.findAllByOrderByRankDesc(), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Movie> getMovieById(int id) {
        try{
            return new ResponseEntity<>(movieDao.findById(id), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<MovieWrapper>> getAllMoviesByScoreAsc() {
        try{
            return new ResponseEntity<>(movieWrapperDao.findAllByOrderByScoreAsc(), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<MovieWrapper>> getAllMoviesByScoreDesc() {
        try{
            return new ResponseEntity<>(movieWrapperDao.findAllByOrderByScoreDesc(), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<MovieWrapper>> getAllMoviesByYearAsc() {
        try{
            return new ResponseEntity<>(movieWrapperDao.findAllByOrderByYearAsc(), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<MovieWrapper>> getAllMoviesByYearDesc() {
        try{
            return new ResponseEntity<>(movieWrapperDao.findAllByOrderByYearDesc(), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
}
