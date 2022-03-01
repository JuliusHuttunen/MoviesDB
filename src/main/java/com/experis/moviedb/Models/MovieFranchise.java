package com.experis.moviedb.Models;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class MovieFranchise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40)
    private String name;

    private String description;

    @JsonGetter("movies")
    public List<String> movies() {
        return movies.stream()
                .map(movie -> {
                    return "/api/movies/" + movie.getId();
                }).collect(Collectors.toList());
    }

    @OneToMany(mappedBy = "franchise", fetch = FetchType.LAZY)
    private Set<Movie> movies;

    public MovieFranchise(){}

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
