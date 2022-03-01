package com.experis.moviedb.Controllers;

import com.experis.moviedb.Models.MovieFranchise;
import com.experis.moviedb.Services.MovieFranchiseService;
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
}