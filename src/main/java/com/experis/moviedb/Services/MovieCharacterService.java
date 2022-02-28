package com.experis.moviedb.Services;

import com.experis.moviedb.Models.MovieCharacter;
import com.experis.moviedb.Repositories.MovieCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieCharacterService {

    @Autowired
    private MovieCharacterRepository characterRepository;

    public List<MovieCharacter> findAll() {
        return characterRepository.findAll();
    }

    public Optional<MovieCharacter> getCharacterById(Long id) {
        return characterRepository.findById(id);
    }

    public MovieCharacter saveCharacter(MovieCharacter character) {
        return characterRepository.save(character);
    }

    public MovieCharacter updateCharacter(MovieCharacter updateCharacter) {
        MovieCharacter character = getCharacterById(updateCharacter.getId()).get();
        character.setId(updateCharacter.getId());
        character.setName(updateCharacter.getName());
        character.setAlias(updateCharacter.getAlias());
        character.setGender(updateCharacter.getGender());
        character.setLinkToPhoto(updateCharacter.getLinkToPhoto());
        return characterRepository.save(character);
    }

    public Boolean deleteCharacter(Long id) {
        characterRepository.deleteById(id);
        return true;
    }
}
