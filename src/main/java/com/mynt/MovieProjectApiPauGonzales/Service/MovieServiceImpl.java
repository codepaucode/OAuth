package com.mynt.MovieProjectApiPauGonzales.Service;

import com.mynt.MovieProjectApiPauGonzales.Enum.Genre;
import com.mynt.MovieProjectApiPauGonzales.Model.Movie;
import com.mynt.MovieProjectApiPauGonzales.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    @PreAuthorize("hasRole('USER')")
    public List<Movie> getAllMovies() {
        return (List<Movie>) movieRepository.findAll();
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    @PreAuthorize("hasRole('USER')")
    public List<Movie> getMoviesByYear(int yearReleased) {
        return movieRepository.findByYearReleased(yearReleased);
    }

    @Override
    @PreAuthorize("hasRole('USER')")
    public List<Movie> getAllMoviesOrderByYearReleased() {
        List<Movie> allMovies = (List<Movie>) movieRepository.findAll();
        allMovies.sort((movie1, movie2) -> Integer.compare(movie1.getYearReleased(), movie2.getYearReleased()));
        return allMovies;
    }

    @Override
    public String deleteMovie(Long movieId) {
        return "";
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteMovie(long movieId) {
        if (movieRepository.existsById(movieId)) {
            movieRepository.deleteById(movieId);
            return "Movie with ID " + movieId + " deleted successfully.";
        } else {
            return "Movie with ID " + movieId + " not found.";
        }
    }

    @Override
    @PreAuthorize("hasRole('USER')")
    public List<Movie> getMoviesByGenreAndNotIsSequel(Genre genre, Boolean isSequel) {
        return movieRepository.findByGenreAndIsSequel(genre, isSequel);
    }

    @Override
    public String getSecurity() {
        return "";
    }
}
