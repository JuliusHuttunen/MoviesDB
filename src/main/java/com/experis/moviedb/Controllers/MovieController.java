package com.experis.moviedb.Controllers;

import com.experis.moviedb.Models.Movie;
import com.experis.moviedb.Models.MovieCharacter;
import com.experis.moviedb.Services.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    MovieService service = new MovieService();

    @Operation(summary = "Get all movies")
    @GetMapping("")
    private ResponseEntity<List<Movie>> getMovies() {
        List<Movie> movies = service.findAll();
        if (!movies.isEmpty())
            return ResponseEntity
                    .ok()
                    .body(movies);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build();
    }

    @Operation(summary = "Get a movie by id")
    @GetMapping("/{id}")
    private ResponseEntity<Movie> getMovie(@PathVariable("id") Long id) {
        Optional<Movie> movie = service.getMovieById(id);
        if (movie.isPresent())
            return ResponseEntity
                    .ok()
                    .body(movie.get());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build();
    }

    @SecurityRequirement(name = "keycloak_implicit")
    @Operation(summary = "Create a new movie")
    @PostMapping("")
    private ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        try {
            Movie result = service.saveMovie(movie);
            return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(result);
        }
        catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @SecurityRequirement(name = "keycloak_implicit")
    @Operation(summary = "Update a movie by id")
    @PutMapping ("/{id}")
    private ResponseEntity<Movie> updateMovie(@RequestBody Movie updateMovie, @PathVariable("id") Long id) {
        try {
            updateMovie.setId(id);
            Movie result = service.saveMovie(updateMovie);
            return ResponseEntity
                    .ok()
                    .body(result);
        }
        catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @SecurityRequirement(name = "keycloak_implicit")
    @Operation(summary = "Delete a movie")
    @DeleteMapping("/{id}")
    private ResponseEntity<Boolean> deleteMovie(@PathVariable("id") Long id) {
        try {
            service.deleteMovie(id);
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        }
        catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @Operation(summary = "Get all the characters in a movie")
    @GetMapping("/{id}/characters")
    private ResponseEntity<List<MovieCharacter>> getFranchiseCharacters(@PathVariable("id") Long id) {
        Movie movie = service.getMovieById(id).get();
        List<MovieCharacter> characterList = service.getCharacterList(movie);
        if (!characterList.isEmpty())
            return ResponseEntity
                    .ok()
                    .body(characterList);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build();
    }

    @SecurityRequirement(name = "keycloak_implicit")
    @Operation(summary = "Update the characters in a movie by character Ids")
    @PutMapping("/{id}/characters")
    private ResponseEntity<Movie> updateCharacters(@PathVariable("id") Long id, @RequestBody Long[] ids){
        Movie movie = service.getMovieById(id).get();
        Movie newMovie = service.updateMovieCharacters(movie, ids);

        return ResponseEntity
                .ok()
                .body(newMovie);
    }
}