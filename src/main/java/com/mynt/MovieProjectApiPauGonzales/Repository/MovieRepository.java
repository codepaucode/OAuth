package com.mynt.MovieProjectApiPauGonzales.Repository;

import com.mynt.MovieProjectApiPauGonzales.Model.Movie;
import com.mynt.MovieProjectApiPauGonzales.Enum.Genre;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Long> {

    // Find movies by year released
    List<Movie> findByYearReleased(int yearReleased);

    // Find movies by genre and isSequel flag
    List<Movie> findByGenreAndIsSequel(Genre genre, Boolean isSequel);
}
