package com.covidinfotracker.controller;

import com.covidinfotracker.model.Country;
import com.covidinfotracker.model.CountryDetails;
import com.covidinfotracker.model.Summary;
import com.covidinfotracker.service.CountryDetailsService;
import com.covidinfotracker.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.List;


@RestController
public class CovidInfoController {
    @Autowired
    private CountryService countryService;

    @Autowired
    private CountryDetailsService countryDetailsService;

    @GetMapping("/addCountries")
    public ResponseEntity<Country> fetchAndAddCountry() throws URISyntaxException {

        return countryService.fetchAndAddCountry();
    }


    @GetMapping("/getcountriesbyid")
    public Country getCountrydataById(@RequestParam(name = "id") Long id) {

        return countryService.getCountryDataById(id);
    }

    @GetMapping("/getcountriesbyname")
    public Country getCountrydataByName(@RequestParam(name = "name") String countryname) {

        return countryService.getCountryDataByName(countryname);
    }

    @GetMapping("/getallcountries")
    public List<Country> getallcountries() {

        return countryService.getAllCountriesData();
    }

    @GetMapping("/addsummary")
    public ResponseEntity<Summary> addSummary() throws URISyntaxException {

        return countryDetailsService.fetchAndAddSummary();
    }

    @GetMapping("/getcountriesfromSummaryById")
    public CountryDetails getCountryDetailsDataById(@RequestParam(name = "id") Long id) {

        return countryDetailsService.getCountryDetailsDataById(id);
    }

    @GetMapping("/getcountriesfromSummaryByName")
    public CountryDetails getCountryDetailsDataByName(@RequestParam(name = "name") String name) {

        return countryDetailsService.getCountryDetailsDataByName(name);
    }

}
