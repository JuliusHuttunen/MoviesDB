package com.experis.moviedb.Services;

import com.experis.moviedb.Models.MovieCharacter;
import com.experis.moviedb.Repositories.MovieCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieCharacterService {

    @Autowired
    private MovieCharacterRepository characterRepository;

    public List<MovieCharacter> findAll() {
        return characterRepository.findAll();
    }

    public MovieCharacter getCharacterById(Long id) {
        return characterRepository.findById(id).get();
    }

    public MovieCharacter saveOrUpdate(MovieCharacter character) {
        return characterRepository.save(character);
    }
}
