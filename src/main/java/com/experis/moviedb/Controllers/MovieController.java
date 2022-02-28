package com.experis.moviedb.Controllers;

import com.experis.moviedb.Models.Movie;
import com.experis.moviedb.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService service = new MovieService();

    @GetMapping("/api/movies")
    private List<Movie> getMovies() {
        return service.findAll();
    }

    @GetMapping("/api/movies/{id}")
    private Movie getMovie(@PathVariable("id") Long id) {
        return service.getMovieById(id);
    }

    @PostMapping("/api/movies")
    private Movie createMovie(@RequestBody Movie movie) {
        service.saveMovie(movie);
        return movie;
    }

    @PutMapping ("api/movies/{id}")
    private Movie updateMovie(@RequestBody Movie updateMovie, @PathVariable("id") Long id) {
        updateMovie.setId(id);
        service.updateMovie(updateMovie);
        return updateMovie;
    }

    @DeleteMapping("api/movies/{id}")
    private Boolean deleteMovie(@PathVariable("id") Long id) {
        return service.deleteMovie(id);
    }
}
