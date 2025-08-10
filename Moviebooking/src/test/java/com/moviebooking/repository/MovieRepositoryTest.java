package com.moviebooking.repository;

import com.moviebooking.entity.Movie;
import com.moviebooking.entity.Theater;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Test
    public void testAddMovie() {
        Theater theater = new Theater();
        theater.setName("PVR");
        theater.setLocation("Mumbai");

        Theater savedTheater = theaterRepository.save(theater);

        Movie movie = new Movie();
        movie.setTitle("Inception");
        movie.setGenre("Sci-Fi");
        movie.setTheater(savedTheater);

        Movie savedMovie = movieRepository.save(movie);

        assertThat(savedMovie.getId()).isNotNull();
        assertThat(savedMovie.getTitle()).isEqualTo("Inception");
        assertThat(savedMovie.getTheater().getName()).isEqualTo("PVR");
    }
}
