package com.experis.moviedb.Controllers;

import com.experis.moviedb.Models.MovieCharacter;
import com.experis.moviedb.Services.MovieCharacterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/characters")
public class MovieCharacterController {

    @Autowired
    MovieCharacterService service = new MovieCharacterService();

    @Operation(summary = "Get all characters")
    @GetMapping("")
    private ResponseEntity<List<MovieCharacter>> getCharacters() {
        List<MovieCharacter> characters = service.findAll();
        if (!characters.isEmpty())
            return ResponseEntity
                    .ok()
                    .body(characters);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build();
    }

    @Operation(summary = "Get a character by Id")
    @GetMapping("/{id}")
    private ResponseEntity<MovieCharacter> getMovieCharacter(@PathVariable("id") Long id) {
        Optional<MovieCharacter> character = service.getCharacterById(id);
        if (character.isPresent())
            return ResponseEntity
                    .ok()
                    .body(character.get());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build();
    }

    @SecurityRequirement(name = "keycloak_implicit")
    @Operation(summary = "Create a new character")
    @PostMapping("")
    private ResponseEntity<MovieCharacter> createCharacter(@RequestBody MovieCharacter character) {
        try {
            MovieCharacter result = service.saveCharacter(character);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(result);
        }
        catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @SecurityRequirement(name = "keycloak_implicit")
    @Operation(summary = "Update a character by Id")
    @PutMapping ("/{id}")
    private ResponseEntity<MovieCharacter> updateCharacter(@RequestBody MovieCharacter updateCharacter, @PathVariable("id") Long id) {
        try {
            updateCharacter.setId(id);
            MovieCharacter result = service.updateCharacter(updateCharacter);
            return ResponseEntity
                    .ok()
                    .body(result);
        }
        catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @SecurityRequirement(name = "keycloak_implicit")
    @Operation(summary = "Delete a character")
    @DeleteMapping("/{id}")
    private ResponseEntity<Boolean> deleteCharacter(@PathVariable("id") Long id) {
        try {
            service.deleteCharacter(id);
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();

        }
        catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}