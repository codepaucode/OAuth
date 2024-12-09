package com.mynt.MovieProjectApiPauGonzales.Service;

import com.mynt.MovieProjectApiPauGonzales.Model.Genre;
import com.mynt.MovieProjectApiPauGonzales.Repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService{

    @Autowired
    GenreRepository genreRepository;

    @Override
    public Genre getGenreById(Long genreId) {
        return genreRepository.findById(genreId).orElse(null);
    }
}
