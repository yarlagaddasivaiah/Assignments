
package com.moviebooking.service;

import com.moviebooking.entity.Movie;
import java.util.List;

public interface MovieService {
    Movie addMovie(Movie movie);
    List<Movie> getAllMovies();
}
