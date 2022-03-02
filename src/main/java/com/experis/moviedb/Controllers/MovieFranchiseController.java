package com.experis.moviedb.Controllers;

import com.experis.moviedb.Models.Movie;
import com.experis.moviedb.Models.MovieCharacter;
import com.experis.moviedb.Models.MovieFranchise;
import com.experis.moviedb.Services.MovieFranchiseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin (origins = "*")
@RequestMapping("/api/franchises")
public class MovieFranchiseController {

    @Autowired
    MovieFranchiseService service;

    @Operation(summary = "Get all franchises")
    @GetMapping("")
    private ResponseEntity<List<MovieFranchise>> getFranchises() {
        List<MovieFranchise> franchises = service.findAll();
        if (!franchises.isEmpty())
            return ResponseEntity
                    .ok()
                    .body(franchises);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build();
    }

    @Operation(summary = "Get a franchise by Id")
    @GetMapping("/{id}")
    private ResponseEntity<MovieFranchise> getMovieFranchise(@PathVariable("id") Long id) {
        Optional<MovieFranchise> franchise =  service.getFranchiseById(id);
        if (franchise.isPresent())
            return ResponseEntity
                    .ok()
                    .body(franchise.get());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build();
    }

    @SecurityRequirement(name = "keycloak_implicit")
    @Operation(summary = "Create a new franchise")
    @PostMapping("")
    private ResponseEntity<MovieFranchise> createFranchise(@RequestBody MovieFranchise franchise) {
        try {
            MovieFranchise result = service.saveFranchise(franchise);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(franchise);
        }
        catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @SecurityRequirement(name = "keycloak_implicit")
    @Operation(summary = "Update a franchise by Id")
    @PutMapping ("/{id}")
    private ResponseEntity<MovieFranchise> updateFranchise(@RequestBody MovieFranchise updateFranchise, @PathVariable("id") Long id) {
        try {
            updateFranchise.setId(id);
            service.updateFranchise(updateFranchise);
            return ResponseEntity
                    .ok()
                    .body(updateFranchise);
        }
        catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @SecurityRequirement(name = "keycloak_implicit")
    @Operation(summary = "Delete a franchise")
    @DeleteMapping("/{id}")
    private ResponseEntity<Boolean> deleteFranchise(@PathVariable("id") Long id) {
        try {
            service.deleteFranchise(id);
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

    @Operation(summary = "Get all the movies in a franchise")
    @GetMapping("/{id}/movies")
    private ResponseEntity<List<Movie>> getFranchiseMovies(@PathVariable("id") Long id) {
        MovieFranchise franchise = service.getFranchiseById(id).get();
        List<Movie> moviesList = service.getMoviesList(franchise);
        if (!moviesList.isEmpty())
            return ResponseEntity
                    .ok()
                    .body(moviesList);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build();
    }

    @Operation(summary = "Get all the characters in a franchise")
    @GetMapping("/{id}/characters")
    private ResponseEntity<List<MovieCharacter>> getFranchiseCharacters(@PathVariable("id") Long id) {
        MovieFranchise franchise = service.getFranchiseById(id).get();
        List<MovieCharacter> characterList = service.getCharacterList(franchise);
        if (!characterList.isEmpty())
            return ResponseEntity
                    .ok()
                    .body(characterList);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build();
    }

    @SecurityRequirement(name = "keycloak_implicit")
    @Operation(summary = "Update the movies in a franchise by movie Ids")
    @PutMapping("/{id}/movies")
    private ResponseEntity<MovieFranchise> updateMovies(@PathVariable("id") Long id, @RequestBody Long[] ids){
        MovieFranchise franchise = service.getFranchiseById(id).get();
        MovieFranchise updated = service.updateFranchiseMovies(franchise, ids);
        return ResponseEntity
                .ok()
                .body(updated);
    }
}