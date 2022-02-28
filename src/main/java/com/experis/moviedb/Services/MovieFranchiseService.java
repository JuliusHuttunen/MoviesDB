package com.experis.moviedb.Services;

import com.experis.moviedb.Models.MovieFranchise;
import com.experis.moviedb.Repositories.MovieFranchiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieFranchiseService {

    @Autowired
    private MovieFranchiseRepository franchiseRepository;

    public List<MovieFranchise> findAll() {
        return franchiseRepository.findAll();
    }

    public Optional<MovieFranchise> getFranchiseById(Long id) {
        return franchiseRepository.findById(id);
    }

    public MovieFranchise saveFranchise(MovieFranchise franchise) {
        return franchiseRepository.save(franchise);
    }

    public MovieFranchise updateFranchise(MovieFranchise updateFranchise) {
        MovieFranchise franchise = getFranchiseById(updateFranchise.getId()).get();
        franchise.setId(updateFranchise.getId());
        franchise.setName(updateFranchise.getName());
        franchise.setDescription(updateFranchise.getDescription());
        return franchiseRepository.save(franchise);
    }

    public Boolean deleteFranchise(Long id) {
        franchiseRepository.deleteById(id);
        return true;
    }
}
