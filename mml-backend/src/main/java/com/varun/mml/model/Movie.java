package com.varun.mml.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Movie {
    @Id
    private int rank;
    private String movieTitle;
    private float score;
    private int movieHours;
    private int movieMinutes;
    private int releaseYear;
    private String rating;
    private float boxOffice;
    private String synopsis;
    private String director;
    private String genreOne;
    private String genreTwo;
    private String language;
    private String imageLink;
    private String releaseDate;
    private String trailer;
}
