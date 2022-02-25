package com.experis.moviedb.Repositories;

import com.experis.moviedb.Models.MovieCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieCharacterRepository extends JpaRepository<MovieCharacter, Long> {
}
