package com.varun.mml.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Tv {
    @Id
    private int rank;
    private String  showTitle;
    private float score;
    private int startYear;
    private int endYear;
    private int episodes;
    private String rating;
    private String synopsis;
    private String genreOne;
    private String genreTwo;
    private String language;
    private String imageLink;
    private String trailer;
}
