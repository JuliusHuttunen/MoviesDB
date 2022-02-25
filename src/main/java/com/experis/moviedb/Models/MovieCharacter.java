package com.experis.moviedb.Models;

import javax.persistence.*;

@Entity
public class MovieCharacter {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String alias;
    private String gender;
    private String linkToPhoto;

    public MovieCharacter() {}

    public MovieCharacter(Long id, String name, String alias, String gender, String linkToPhoto) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.gender = gender;
        this.linkToPhoto = linkToPhoto;
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
}
