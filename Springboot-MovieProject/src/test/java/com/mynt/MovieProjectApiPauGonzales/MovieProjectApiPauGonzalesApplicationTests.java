package com.mynt.MovieProjectApiPauGonzales;

import com.mynt.MovieProjectApiPauGonzales.Model.Movie;
import com.mynt.MovieProjectApiPauGonzales.Repository.MovieRepository;
import com.mynt.MovieProjectApiPauGonzales.Service.MovieService;
import com.mynt.MovieProjectApiPauGonzales.Service.MovieServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MovieProjectApiPauGonzalesApplicationTests {

    @Autowired
    private MovieService movieService;

    @MockBean
    private MovieRepository movieRepository; // Mocking the repository

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void testGetAllMoviesWithUserRole() {
        // Mock repository behavior
        when(movieRepository.findAll()).thenReturn(Collections.singletonList(new Movie()));

        // Test the service method
        var movies = movieService.getAllMovies();
        assertNotNull(movies);
        assertFalse(movies.isEmpty());
    }

    @Test
    @WithMockUser(roles = "ADMIN")  // Ensure that the user has the "ADMIN" role
    public void testDeleteMovieWithAdminRole() {
        // Act: Call the method you're testing
        String response = movieService.deleteMovie(1L);  // Call the method from movieService

        // Assert: Ensure deleteById is called once
        verify(movieRepository, times(1)).deleteById(1L);  // Ensure deleteById is called once
        assertEquals("Movie with ID 1 deleted successfully.", response);  // Assert the returned message
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void testGetMoviesByGenreAndNotIsSequelWithUserRole() {
        // Mock repository behavior
        when(movieRepository.findByGenreAndIsSequel(any(), anyBoolean())).thenReturn(Collections.singletonList(new Movie()));

        // Test the service method
        var movies = movieService.getMoviesByGenreAndNotIsSequel(null, false);
        assertNotNull(movies);
        assertFalse(movies.isEmpty());
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void testAccessDeniedForAdminRole() {
        // Test if AccessDeniedException is thrown when a non-admin user tries to delete
        assertThrows(AccessDeniedException.class, () -> movieService.deleteMovie(1L));
    }
}
