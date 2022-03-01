package com.experis.moviedb.Services;

import com.experis.moviedb.Models.Movie;
import com.experis.moviedb.Models.MovieCharacter;
import com.experis.moviedb.Repositories.MovieCharacterRepository;
import com.experis.moviedb.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieCharacterRepository characterRepository;

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

    public List<MovieCharacter> getCharacterList(Movie movie){
        Set<MovieCharacter> characters = movie.getCharacters();
        List<MovieCharacter> characterList = characters.stream().toList();
        return characterList;
    }

    public Movie updateMovieCharacters(Movie movie, Long[] ids) {
        Set<MovieCharacter> characters = new HashSet<>();
        for (Long charId : ids) {
            MovieCharacter byId = characterRepository.findById(charId).get();
            characters.add(byId);
        }
        movie.setCharacters(characters);
        movieRepository.save(movie);
        return movie;
    }
}
