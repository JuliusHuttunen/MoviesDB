package com.experis.moviedb;

import com.experis.moviedb.Models.MovieCharacter;
import com.experis.moviedb.Services.MovieCharacterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MoviedbApplicationTests {

	@Autowired
	MovieCharacterService characterService;

	@Test
	public void hibernateCreatesCharacters() {
		List<MovieCharacter> characters = characterService.getAll();

		assertEquals(characters.size(), 3);
	}

}
