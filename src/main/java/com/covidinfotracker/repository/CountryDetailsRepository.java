package com.covidinfotracker.repository;


import com.covidinfotracker.model.Country;
import com.covidinfotracker.model.CountryDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryDetailsRepository extends JpaRepository<CountryDetails,Long> {

   CountryDetails findByCountry(String country1);
}
