package com.experis.moviedb.Controllers;

import com.experis.moviedb.Models.MovieFranchise;
import com.experis.moviedb.Services.MovieFranchiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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


}
