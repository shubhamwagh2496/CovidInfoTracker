package com.covidinfotracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


public class Summary{

    @JsonProperty("Global")
    private Global global;

    @JsonProperty("Countries")
    private List<CountryDetails> countries;

    @JsonProperty("Date")
    private Date date;

    public void setGlobal(Global global) {
        this.global = global;
    }


    public void setCountries(List<CountryDetails> countries) {
        this.countries = countries;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Global getGlobal() {
        return global;
    }

    public List<CountryDetails> getCountries() {
        return countries;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Root{" +
                "global=" + global +
                ", countries=" + countries +
                ", date=" + date +
                '}';
    }
}

