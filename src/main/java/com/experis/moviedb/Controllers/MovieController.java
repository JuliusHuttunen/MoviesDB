package com.experis.moviedb.Controllers;

import com.experis.moviedb.Models.Movie;
import com.experis.moviedb.Services.MovieService;
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

    @GetMapping("")
    private ResponseEntity<List<Movie>> getMovies() {
        List<Movie> movies = service.findAll();
        if (!movies.isEmpty())
            return ResponseEntity
                    .ok()
                    .body(movies);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .header("Message", "No movies found!")
                .build();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Movie> getMovie(@PathVariable("id") Long id) {
        Optional<Movie> movie = service.getMovieById(id);
        if (movie.isPresent())
            return ResponseEntity
                    .ok()
                    .body(movie.get());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .header("Message", "Movie not found!")
                .build();
    }

    @PostMapping("")
    private ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        service.saveMovie(movie);
        return ResponseEntity
                .ok()
                .body(movie);
    }

    @PutMapping ("/{id}")
    private ResponseEntity<Movie> updateMovie(@RequestBody Movie updateMovie, @PathVariable("id") Long id) {
        updateMovie.setId(id);
        service.updateMovie(updateMovie);
        return ResponseEntity
                .ok()
                .body(updateMovie);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Boolean> deleteMovie(@PathVariable("id") Long id) {
        boolean result = service.deleteMovie(id);
        return ResponseEntity
                .ok()
                .body(result);
    }
}