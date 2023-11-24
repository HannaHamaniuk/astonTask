package by.anne.controller;

import by.anne.model.entities.Country;
import by.anne.model.entities.Union;
import by.anne.model.entities.UnionInCountry;
import by.anne.model.repositories.CountryRepository;
import by.anne.model.repositories.UnionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UnionController {
    private CountryRepository countryRepository;

    @Autowired
    public void setCountryRepository(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    private UnionRepository unionRepository;

    @GetMapping("/addUnion/{id}")
    public ModelAndView addBook(@PathVariable int id) {
        return new ModelAndView("add-union", "union", new UnionInCountry(id));
    }


    @Autowired
    public void setUnionRepository(UnionRepository unionRepository) {
        this.unionRepository = unionRepository;
    }

    @PostMapping("/saveUnion")
    public String saveUnion(@ModelAttribute(name = "union") UnionInCountry unionInCountry) {
        Union union = new Union();
        union.setTitle(unionInCountry.getTitle());
        Country country = countryRepository.findFullList(unionInCountry.getCountry_id());
        List<Country> countries= new ArrayList<>();
        countries.add(country);
        union.setCountries(countries);
        unionRepository.save(union);
        return "redirect:/view/" + unionInCountry.getCountry_id();

    }
}
