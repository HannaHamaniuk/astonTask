package by.anne.controller;

import by.anne.exceptions.NoSuchCountryException;
import by.anne.model.entities.Country;
import by.anne.model.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restCountry")
public class CountryRestController {
    private CountryRepository countryRepository;

    @Autowired

    public void setCountryRepository(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping("/countries")
    public List<Country> showAllCountries() {
        List<Country> countries = countryRepository.findAll();
        System.out.println(countries);
        return countries;
    }

    @GetMapping("/country/{id}")
    public Country getCountryById(@PathVariable("id") int id){
        Optional<Country> countryOptional = countryRepository.findById(id);
        Country country = countryOptional.get();
        if(country==null){
            throw new NoSuchCountryException("There is no country with such id");
        }
        return country;


    }



}
