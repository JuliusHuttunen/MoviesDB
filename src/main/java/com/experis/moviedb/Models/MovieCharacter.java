package com.experis.moviedb.Models;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class MovieCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40)
    private String name;

    @Column(length = 40)
    private String alias;

    @Column(length = 10)
    private String gender;

    @Column
    private String linkToPhoto;

    @JsonGetter("movies")
    public List<String> movies() {
        if (movies != null) {
            return movies.stream()
                    .map(movie -> {
                        return "/api/movies/" + movie.getId();
                    }).collect(Collectors.toList());
        }
        return null;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "character_movie", joinColumns = @JoinColumn(name = "movie_character_id"), inverseJoinColumns = @JoinColumn(name = "movie_id"))
    @Valid
    private Set<Movie> movies;

    public MovieCharacter() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLinkToPhoto() {
        return linkToPhoto;
    }

    public void setLinkToPhoto(String linkToPhoto) {
        this.linkToPhoto = linkToPhoto;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
