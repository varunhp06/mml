package com.varun.mml.service;

import com.varun.mml.dao.MovieDao;
import com.varun.mml.model.Movie;
import com.varun.mml.model.MovieWrapper;
import com.varun.mml.dao.MovieWrapperDao;
import com.varun.mml.movie.MovieMapper;
import com.varun.mml.movie.MovieRequest;
import com.varun.mml.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieWrapperDao movieWrapperDao;
    private final MovieDao movieDao;
    private final MovieMapper movieMapper;

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

    public Integer save(MovieRequest request, Authentication connectedUser) {
        User user = ((User) connectedUser.getPrincipal());
        Movie movie = movieMapper.toMovie(request);
        List<User> list = movie.getUsers();
        list.add(user);
        movie.setUsers(list);
        return movieDao.save(movie).getRank();
    }

    public ResponseEntity<List<Movie>> getAllMoviesByOwner(Authentication connectedUser) {
        User user = (User)connectedUser.getPrincipal();
        return new ResponseEntity<>(user.getMovies(), HttpStatus.OK);
    }
}
