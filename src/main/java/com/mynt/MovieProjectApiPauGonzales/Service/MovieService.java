package com.mynt.MovieProjectApiPauGonzales.Service;

import com.mynt.MovieProjectApiPauGonzales.Enum.Genre;
import com.mynt.MovieProjectApiPauGonzales.Model.Movie;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    Movie saveMovie(Movie movie);
    List<Movie> getMoviesByYear(int yearReleased);
    List<Movie>  getAllMoviesOrderByYearReleased();

    @PreAuthorize("hasRole('ADMIN')")
    String deleteMovie(Long movieId);

    List<Movie> getMoviesByGenreAndNotIsSequel(Genre genre, Boolean isSequel);
    String getSecurity();

    String deleteMovie(long movieId);
}