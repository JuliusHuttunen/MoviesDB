package com.experis.moviedb.Repositories;

import com.experis.moviedb.Models.MovieFranchise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieFranchiseRepository extends JpaRepository<MovieFranchise, Long> {
}
