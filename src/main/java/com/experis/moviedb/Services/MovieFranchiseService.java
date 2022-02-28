package com.experis.moviedb.Services;

import com.experis.moviedb.Models.MovieFranchise;
import com.experis.moviedb.Repositories.MovieFranchiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieFranchiseService {

    @Autowired
    private MovieFranchiseRepository franchiseRepository;

    public List<MovieFranchise> findAll() {
        return franchiseRepository.findAll();
    }

    public MovieFranchise getFranchiseById(Long id) {
        return franchiseRepository.findById(id).get();
    }
}
