package com.experis.moviedb.Controllers;

import com.experis.moviedb.Models.Movie;
import com.experis.moviedb.Models.MovieCharacter;
import com.experis.moviedb.Models.MovieFranchise;
import com.experis.moviedb.Repositories.MovieCharacterRepository;
import com.experis.moviedb.Repositories.MovieFranchiseRepository;
import com.experis.moviedb.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class RelationController {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MovieCharacterRepository characterRepository;

    @Autowired
    MovieFranchiseRepository franchiseRepository;

    @PutMapping("/movies/{id}/characters/update")
    private ResponseEntity<Movie> updateCharacters(@PathVariable("id") Long id, @RequestBody Long[] ids){
        Movie movie = movieRepository.findById(id).get();
        Set<MovieCharacter> characters = new HashSet<>();
        for (Long charId : ids) {
           MovieCharacter byId = characterRepository.findById(charId).get();
           characters.add(byId);
        }
        movie.setCharacters(characters);
        movieRepository.save(movie);
        return ResponseEntity
                .ok()
                .body(movie);
    }

    @PutMapping("/franchises/{id}/movies/update")
    private ResponseEntity<MovieFranchise> updateMovies(@PathVariable("id") Long id, @RequestBody Long[] ids){
        MovieFranchise franchise = franchiseRepository.findById(id).get();
        for (Long charId : ids) {
            Movie byId = movieRepository.findById(charId).get();
            byId.setFranchise(franchise);
            movieRepository.save(byId);
        }
        franchiseRepository.save(franchise);
        return ResponseEntity
                .ok()
                .body(franchise);
    }

}
