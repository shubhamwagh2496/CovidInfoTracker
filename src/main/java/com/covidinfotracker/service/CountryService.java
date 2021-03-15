package com.covidinfotracker.service;

import com.covidinfotracker.model.Country;
import com.covidinfotracker.model.CountryDetails;
import com.covidinfotracker.model.Summary;
import com.covidinfotracker.repository.CountryDetailsRepository;
import com.covidinfotracker.repository.CountryrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryrRepository countryrRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Environment env;

    public ResponseEntity<Country> fetchAndAddCountry() throws URISyntaxException {

        URI uri = new URI("https://api.covid19api.com/countries");
        HttpHeaders headers = new HttpHeaders();
        // headers.set("x-rapidapi-key", "d389aa5358msh4674e22ec76993ep1fb164jsnd244ab94763a");
        // headers.set("x-rapidapi-host","covid-19-tracking.p.rapidapi.com");
        HttpEntity<String> request = new HttpEntity<String>(headers);
        ResponseEntity<Country> countryData = restTemplate.exchange(uri, HttpMethod.GET, request, Country.class);
        List<Country> countryList = (List<Country>) countryData.getBody();

        System.out.println(countryList);
        //for (int i = 0; i < countryList.size(); i++)
           // countryrRepository.save(countryList.get(i));
        return countryData;
    }

    public Country getCountryDataById(Long id) {

        Optional<Country> country = countryrRepository.findById(id);
        System.out.println(country.get());
        return country.get();
    }

    public Country getCountryDataByName(String countryName) {

        Country country = countryrRepository.findBycountryName(countryName);
        System.out.println(country);
        return country;
    }

    public List<Country> getAllCountriesData() {

        List<Country> allCountriesList = countryrRepository.findAll();
        System.out.println(allCountriesList);
        return allCountriesList;
    }

}
