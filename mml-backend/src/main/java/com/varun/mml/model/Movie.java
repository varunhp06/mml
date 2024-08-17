package com.varun.mml.model;

import com.varun.mml.user.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
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
    @ManyToMany(mappedBy = "movies")
    private List<User> users;
}
