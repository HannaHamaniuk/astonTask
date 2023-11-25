package by.anne.controller;

import by.anne.model.entities.Country;
import by.anne.model.entities.Union;
import by.anne.model.repositories.CountryRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

    @GetMapping("/add")
    public ModelAndView add(){
        return new ModelAndView("add-country", "country", new Country());
    }
    @PostMapping("/save")
    public String save(@ModelAttribute(name="country")Country country){
        countryRepository.save(country);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        countryRepository.deleteById(id);

        return "redirect:/";

    }
    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable int id){
        Country country =  countryRepository.findById(id).get();
        return new ModelAndView("upd-country", "country", country);

    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
       Country country = countryRepository.findFullList(id);
        model.addAttribute("country", country);
        return"country";


    }

}
