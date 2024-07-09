package com.varun.mml.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class MovieWrapper {
    @Id
    private int rank;
    private String movieTitle;
    private float score;
    private int movieHours;
    private int movieMinutes;
    private int releaseYear;
    private String rating;
    private float boxOffice;
}
