package com.varun.mml.dao;

import com.varun.mml.model.TvWrapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TvWrapperDao extends JpaRepository<TvWrapper, Integer> {

    @Query(value = "SELECT * FROM tv ORDER BY rank ASC", nativeQuery = true)
    List<TvWrapper> findAllByOrderByRankAsc();

    @Query(value = "SELECT * FROM tv ORDER BY rank DESC", nativeQuery = true)
    List<TvWrapper> findAllByOrderByRankDesc();

    @Query(value = "SELECT * FROM tv ORDER BY score ASC, rank DESC", nativeQuery = true)
    List<TvWrapper> findAllByOrderByScoreAsc();

    @Query(value = "SELECT * FROM tv ORDER BY score DESC, rank ASC", nativeQuery = true)
    List<TvWrapper> findAllByOrderByScoreDesc();

    @Query(value = "SELECT * FROM tv ORDER BY start_year ASC", nativeQuery = true)
    List<TvWrapper> findAllByOrderByStartYearAsc();

    @Query(value = "SELECT * FROM tv ORDER BY start_year DESC", nativeQuery = true)
    List<TvWrapper> findAllByOrderByStartYearDesc();
}
