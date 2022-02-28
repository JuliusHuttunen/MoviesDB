package com.experis.moviedb.Controllers;

import com.experis.moviedb.Models.MovieCharacter;
import com.experis.moviedb.Services.MovieCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieCharacterController {

    @Autowired
    MovieCharacterService service = new MovieCharacterService();

    @GetMapping("/api/characters")
    private List<MovieCharacter> getCharacters() {
        return service.findAll();
    }

    @GetMapping("api/characters/{id}")
    private MovieCharacter getMovieCharacter(@PathVariable("id") Long id) {
        return service.getCharacterById(id);
    }

    @PostMapping("/api/characters")
    private MovieCharacter createCharacter(@RequestBody MovieCharacter character) {
        service.saveCharacter(character);
        return character;
    }

    @PutMapping ("api/characters/{id}")
    private MovieCharacter updateCharacter(@RequestBody MovieCharacter updateCharacter, @PathVariable("id") Long id) {
        updateCharacter.setId(id);
        service.updateCharacter(updateCharacter);
        return updateCharacter;
    }

    @DeleteMapping("api/characters/{id}")
    private Boolean deleteCharacter(@PathVariable("id") Long id) {
        return service.deleteCharacter(id);
    }
}
