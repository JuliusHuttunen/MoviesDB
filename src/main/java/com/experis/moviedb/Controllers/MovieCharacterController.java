package com.experis.moviedb.Controllers;

import com.experis.moviedb.Models.MovieCharacter;
import com.experis.moviedb.Services.MovieCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieCharacterController {

    @Autowired
    MovieCharacterService service = new MovieCharacterService();

    @GetMapping("/api/characters")
    public List<MovieCharacter> getCharacters() {
        return service.getAll();
    }
}
