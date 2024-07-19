package com.varun.mml.dao;

import com.varun.mml.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDao extends JpaRepository<Movie, Integer> {
    Movie findById(int id);
}
