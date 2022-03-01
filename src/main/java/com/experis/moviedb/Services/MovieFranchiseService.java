package com.experis.moviedb.Services;

import com.experis.moviedb.Models.Movie;
import com.experis.moviedb.Models.MovieCharacter;
import com.experis.moviedb.Models.MovieFranchise;
import com.experis.moviedb.Repositories.MovieFranchiseRepository;
import com.experis.moviedb.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MovieFranchiseService {

    @Autowired
    private MovieFranchiseRepository franchiseRepository;

    @Autowired
    private MovieRepository movieRepository;

    public List<MovieFranchise> findAll() {
        return franchiseRepository.findAll();
    }

    public Optional<MovieFranchise> getFranchiseById(Long id) {
        return franchiseRepository.findById(id);
    }

    public MovieFranchise saveFranchise(MovieFranchise franchise) {
        return franchiseRepository.save(franchise);
    }

    public MovieFranchise updateFranchise(MovieFranchise updateFranchise) {
        MovieFranchise franchise = getFranchiseById(updateFranchise.getId()).get();
        franchise.setId(updateFranchise.getId());
        franchise.setName(updateFranchise.getName());
        franchise.setDescription(updateFranchise.getDescription());
        return franchiseRepository.save(franchise);
    }

    public Boolean deleteFranchise(Long id) {
        franchiseRepository.deleteById(id);
        return true;
    }

    public List<Movie> getMoviesList(MovieFranchise franchise){
        Set<Movie> movies = franchise.getMovies();
        return movies.stream().toList();
    }

    public List<MovieCharacter> getCharacterList(MovieFranchise franchise){
        Set<Movie> movies = franchise.getMovies();
        Set<MovieCharacter> characters = new HashSet<>();
        for (Movie m : movies){
            for (MovieCharacter mc : m.getCharacters()){
                characters.add(mc);
            }
        }
        return characters.stream().toList();
    }

    public MovieFranchise updateFranchiseMovies(MovieFranchise franchise, Long[] ids) {
        for (Long charId : ids) {
            Movie byId = movieRepository.findById(charId).get();
            byId.setFranchise(franchise);
            movieRepository.save(byId);
        }
        franchiseRepository.save(franchise);
        return franchise;
    }
}
