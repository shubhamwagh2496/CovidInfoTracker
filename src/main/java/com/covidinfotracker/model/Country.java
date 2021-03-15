package com.covidinfotracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Country {

    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @JsonProperty("Country")
    @Column
    private String countryName;
    @JsonProperty("Slug")
    @Column
    private String slug;
    @JsonProperty("ISO2")
    @Column
    private String iso2;

    public Country() {
    }

    public Country(String countryName, String slug, String iso2) {
        this.countryName = countryName;
        this.slug = slug;
        this.iso2 = iso2;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryname) {
        this.countryName = countryname;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                ", slug='" + slug + '\'' +
                ", iso2='" + iso2 + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
