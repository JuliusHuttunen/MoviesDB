package com.experis.moviedb.Controllers;

import com.experis.moviedb.Models.MovieFranchise;
import com.experis.moviedb.Services.MovieFranchiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieFranchiseController {

    @Autowired
    MovieFranchiseService service;

    @GetMapping("/api/franchises")
    private List<MovieFranchise> getFranchises() {
        return service.findAll();
    }

    @GetMapping("api/franchises/{id}")
    private MovieFranchise getMovieFranchise(@PathVariable("id") Long id) {
        return service.getFranchiseById(id);
    }

    @PostMapping("/api/franchises")
    private MovieFranchise createFranchise(@RequestBody MovieFranchise franchise) {
        service.saveFranchise(franchise);
        return franchise;
    }

    @PutMapping ("api/franchises/{id}")
    private MovieFranchise updateFranchise(@RequestBody MovieFranchise updateFranchise, @PathVariable("id") Long id) {
        updateFranchise.setId(id);
        service.updateFranchise(updateFranchise);
        return updateFranchise;
    }

    @DeleteMapping("api/franchises/{id}")
    private Boolean deleteFranchise(@PathVariable("id") Long id) {
        return service.deleteFranchise(id);
    }
}
