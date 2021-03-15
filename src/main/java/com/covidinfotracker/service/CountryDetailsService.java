package com.covidinfotracker.service;

import com.covidinfotracker.model.CountryDetails;
import com.covidinfotracker.model.Summary;
import com.covidinfotracker.repository.CountryDetailsRepository;
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
import java.util.Optional;

@Service
public class CountryDetailsService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CountryDetailsRepository countryDetailsRepository;
    @Autowired
    private Environment env;

    public ResponseEntity<Summary> fetchAndAddSummary() throws URISyntaxException {
        URI uri = new URI("https://api.covid19api.com/summary");
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<String>(headers);
        System.out.println("Rest Template: " + restTemplate);
        ResponseEntity<Summary> summaryData = restTemplate.exchange(uri, HttpMethod.GET, request, Summary.class);
        Summary summary = summaryData.getBody();
        System.out.println(summary.getCountries().toString());

        for (int i = 0; i < summary.getCountries().size(); i++)
            countryDetailsRepository.save(summary.getCountries().get(i));
        return summaryData;
    }
    public CountryDetails getCountryDetailsDataById(Long id) {

        Optional<CountryDetails> countryDetails = countryDetailsRepository.findById(id);
        System.out.println(countryDetails.get());
        return countryDetails.get();
    }
    public CountryDetails getCountryDetailsDataByName(String countryName) {

        CountryDetails countryDetails = countryDetailsRepository.findByCountry(countryName);
        System.out.println(countryDetails);
        return countryDetails;
    }

}
