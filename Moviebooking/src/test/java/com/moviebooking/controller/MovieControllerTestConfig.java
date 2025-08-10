
package com.moviebooking.controller;

import com.moviebooking.service.MovieService;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class MovieControllerTestConfig {

    @Bean
    public MovieService movieService() {
        return Mockito.mock(MovieService.class);
    }
}
