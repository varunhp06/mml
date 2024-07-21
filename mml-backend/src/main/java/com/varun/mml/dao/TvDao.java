package com.varun.mml.dao;

import com.varun.mml.model.Tv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TvDao extends JpaRepository<Tv, Integer> {
    Tv findById(int id);
}
