package by.anne.controller;

import by.anne.model.entities.Country;
import by.anne.model.entities.Union;
import by.anne.model.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model){
         Country country = countryRepository.findFullList().get(id);
         List<Union>unions = country.getUnions();
        System.out.println(country.getUnions());
         model.addAttribute("unions", unions);
         return "country";

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
}
