package com.varun.mml.movie;

import com.varun.mml.model.Movie;
import org.springframework.stereotype.Service;

@Service
public class MovieMapper {
    public Movie toMovie(MovieRequest request) {
        return Movie.builder()
                .rank(request.id())
                .movieTitle(request.movieTitle())
                .score(request.score())
                .movieHours(request.movieHours())
                .movieMinutes(request.movieMinutes())
                .releaseYear(request.releaseYear())
                .rating(request.rating())
                .boxOffice(request.boxOffice())
                .synopsis(request.synopsis())
                .director(request.director())
                .genreOne(request.genreOne())
                .genreTwo(request.genreTwo())
                .language(request.language())
                .imageLink(request.imageLink())
                .trailer(request.trailer())
                .releaseDate(request.releaseDate())
                .build();
    }
}
