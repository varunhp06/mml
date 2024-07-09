package com.varun.mml.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class TvWrapper {
    @Id
    private int rank;
    private String  showTitle;
    private float score;
    private int startYear;
    private int endYear;
    private int episodes;
    private String rating;
}
