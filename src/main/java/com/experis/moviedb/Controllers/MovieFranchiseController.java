package com.experis.moviedb.Controllers;

import com.experis.moviedb.Models.MovieFranchise;
import com.experis.moviedb.Services.MovieFranchiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin (origins = "*")
@RequestMapping("/api/franchises")
public class MovieFranchiseController {

    @Autowired
    MovieFranchiseService service;

    @GetMapping("")
    private List<MovieFranchise> getFranchises() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    private MovieFranchise getMovieFranchise(@PathVariable("id") Long id) {
        return service.getFranchiseById(id);
    }

    @PostMapping("")
    private MovieFranchise createFranchise(@RequestBody MovieFranchise franchise) {
        service.saveFranchise(franchise);
        return franchise;
    }

    @PutMapping ("/{id}")
    private MovieFranchise updateFranchise(@RequestBody MovieFranchise updateFranchise, @PathVariable("id") Long id) {
        updateFranchise.setId(id);
        service.updateFranchise(updateFranchise);
        return updateFranchise;
    }

    @DeleteMapping("/{id}")
    private Boolean deleteFranchise(@PathVariable("id") Long id) {
        return service.deleteFranchise(id);
    }
}
