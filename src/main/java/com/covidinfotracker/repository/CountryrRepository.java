package com.covidinfotracker.repository;



import com.covidinfotracker.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryrRepository extends JpaRepository<Country,Long> {

Country findBycountryName(String countryName);

}
