package com.experis.moviedb.Models;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String genre;

    @Column
    private int releaseYear;

    @Column
    private String director;

    @Column
    private String picture;

    @Column
    private String linkToTrailer;

    @JsonGetter("franchise")
    public String franchise() {
        return "/api/franchises/" + franchise.getId();
    }

    @ManyToOne
    @JoinColumn(name="franchise_id")
    private MovieFranchise franchise;

    @JsonGetter("characters")
    public List<String> characters() {
        return characters.stream()
                .map(character -> {
                    return "/api/characters/" + character.getId();
                }).collect(Collectors.toList());
    }

    @ManyToMany
    @JoinTable(
            name = "character_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_character_id")
    )
    private Set<MovieCharacter> characters;

    public Movie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getLinkToTrailer() {
        return linkToTrailer;
    }

    public void setLinkToTrailer(String linkToTrailer) {
        this.linkToTrailer = linkToTrailer;
    }

    public MovieFranchise getFranchise() {
        return franchise;
    }

    public void setFranchise(MovieFranchise franchise) {
        this.franchise = franchise;
    }

    public Set<MovieCharacter> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<MovieCharacter> characters) {
        this.characters = characters;
    }
}
