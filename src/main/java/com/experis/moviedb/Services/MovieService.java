package com.experis.moviedb.Services;

import com.experis.moviedb.Models.Movie;
import com.experis.moviedb.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public Movie saveMovie(Movie Movie) {
        return movieRepository.save(Movie);
    }

    public Movie updateMovie(Movie updateMovie) {
        Movie Movie = getMovieById(updateMovie.getId()).get();
        Movie.setId(updateMovie.getId());
        Movie.setTitle(updateMovie.getTitle());
        Movie.setGenre(updateMovie.getGenre());
        Movie.setDirector(updateMovie.getDirector());
        Movie.setReleaseYear(updateMovie.getReleaseYear());
        Movie.setPicture(updateMovie.getPicture());
        Movie.setLinkToTrailer(updateMovie.getLinkToTrailer());
        return movieRepository.save(Movie);
    }

    public Boolean deleteMovie(Long id) {
        movieRepository.deleteById(id);
        return true;
    }
}
