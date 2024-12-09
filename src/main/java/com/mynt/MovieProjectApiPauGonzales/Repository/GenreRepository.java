package com.mynt.MovieProjectApiPauGonzales.Repository;

import com.mynt.MovieProjectApiPauGonzales.Model.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long> {
    Genre getGenreById(Long genreId);
}