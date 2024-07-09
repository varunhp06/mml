package com.varun.mml.dao;

import com.varun.mml.model.MovieWrapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieDao extends JpaRepository <MovieWrapper, Integer>{
    @Query(value = "SELECT * FROM movie ORDER BY rank ASC", nativeQuery = true)
    List<MovieWrapper> findAllByOrderByRankAsc();

    @Query(value = "SELECT * FROM movie ORDER BY rank DESC", nativeQuery = true)
    List<MovieWrapper> findAllByOrderByRankDesc();

    MovieWrapper findById(int id);

    @Query(value = "SELECT * FROM movie ORDER BY score ASC, rank DESC", nativeQuery = true)
    List<MovieWrapper> findAllByOrderByScoreAsc();

    @Query(value = "SELECT * FROM movie ORDER BY score DESC, rank ASC", nativeQuery = true)
    List<MovieWrapper> findAllByOrderByScoreDesc();

    @Query(value = "SELECT * FROM movie ORDER BY release_year ASC", nativeQuery = true)
    List<MovieWrapper> findAllByOrderByYearAsc();

    @Query(value = "SELECT * FROM movie ORDER BY release_year DESC", nativeQuery = true)
    List<MovieWrapper> findAllByOrderByYearDesc();
}
