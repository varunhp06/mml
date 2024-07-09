package com.varun.mml.service;

import com.varun.mml.model.MovieWrapper;
import com.varun.mml.dao.MovieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieDao movieDao;

    public ResponseEntity<List<MovieWrapper>> getAllMovies() {
        try{
            return new ResponseEntity<>(movieDao.findAllByOrderByRankAsc(), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<MovieWrapper>> getAllMoviesDesc() {
        try{
            return new ResponseEntity<>(movieDao.findAllByOrderByRankDesc(), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<MovieWrapper> getMovieById(int id) {
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
            return new ResponseEntity<>(movieDao.findAllByOrderByScoreAsc(), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<MovieWrapper>> getAllMoviesByScoreDesc() {
        try{
            return new ResponseEntity<>(movieDao.findAllByOrderByScoreDesc(), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<MovieWrapper>> getAllMoviesByYearAsc() {
        try{
            return new ResponseEntity<>(movieDao.findAllByOrderByYearAsc(), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<MovieWrapper>> getAllMoviesByYearDesc() {
        try{
            return new ResponseEntity<>(movieDao.findAllByOrderByYearDesc(), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
}
