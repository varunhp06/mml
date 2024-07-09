package com.varun.mml.service;

import com.varun.mml.dao.TvDao;
import com.varun.mml.model.TvWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TvService {
    @Autowired
    TvDao tvDao;

    public ResponseEntity<List<TvWrapper>> getAllShows() {
        try{
            return new ResponseEntity<>(tvDao.findAllByOrderByRankAsc(), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<TvWrapper>> getAllShowsDesc() {
        try{
            return new ResponseEntity<>(tvDao.findAllByOrderByRankDesc(), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<TvWrapper> getShowById(int id) {
        try{
            return new ResponseEntity<>(tvDao.findById(id), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<TvWrapper>> getAllShowsByScoreAsc() {
        try{
            return new ResponseEntity<>(tvDao.findAllByOrderByScoreAsc(), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<TvWrapper>> getAllShowsByScoreDesc() {
        try{
            return new ResponseEntity<>(tvDao.findAllByOrderByScoreDesc(), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<TvWrapper>> getAllShowsByStartYearAsc() {
        try{
            return new ResponseEntity<>(tvDao.findAllByOrderByStartYearAsc(), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<TvWrapper>> getAllShowsByStartYearDesc() {
        try{
            return new ResponseEntity<>(tvDao.findAllByOrderByStartYearDesc(), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
}
