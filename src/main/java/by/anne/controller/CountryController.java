package by.anne.controller;

import by.anne.model.entities.Country;
import by.anne.model.repositories.CountryRepository;
import by.anne.model.repositories.UnionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CountryController {
    private CountryRepository countryRepository;


    @Autowired
    public void setCountryRepository(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping
    public String getAll(Model model){
        List<Country> countries = countryRepository.findAll();
        model.addAttribute("countries", countries);
        return "index";
    }
}
