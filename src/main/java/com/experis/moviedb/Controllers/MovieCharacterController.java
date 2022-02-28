package com.experis.moviedb.Controllers;

import com.experis.moviedb.Models.MovieCharacter;
import com.experis.moviedb.Services.MovieCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/characters")
public class MovieCharacterController {

    @Autowired
    MovieCharacterService service = new MovieCharacterService();

    @GetMapping("")
    private List<MovieCharacter> getCharacters() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    private MovieCharacter getMovieCharacter(@PathVariable("id") Long id) {
        return service.getCharacterById(id);
    }

    @PostMapping("")
    private MovieCharacter createCharacter(@RequestBody MovieCharacter character) {
        service.saveCharacter(character);
        return character;
    }

    @PutMapping ("/{id}")
    private MovieCharacter updateCharacter(@RequestBody MovieCharacter updateCharacter, @PathVariable("id") Long id) {
        updateCharacter.setId(id);
        service.updateCharacter(updateCharacter);
        return updateCharacter;
    }

    @DeleteMapping("/{id}")
    private Boolean deleteCharacter(@PathVariable("id") Long id) {
        return service.deleteCharacter(id);
    }
}
