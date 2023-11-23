package by.anne.controller;

import by.anne.model.repositories.CountryRepository;
import by.anne.model.repositories.UnionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CountryController {
    private CountryRepository countryRepository;


    @Autowired
    public void setCountryRepository(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
}
