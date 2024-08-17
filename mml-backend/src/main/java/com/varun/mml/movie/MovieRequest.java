package com.varun.mml.movie;

public record MovieRequest(
        Integer id,
        String movieTitle,
        float score,
        int movieHours,
        int movieMinutes,
        int releaseYear,
        String rating,
        float boxOffice,
        String synopsis,
        String director,
        String genreOne,
        String genreTwo,
        String language,
        String imageLink,
        String releaseDate,
        String trailer
){
}
