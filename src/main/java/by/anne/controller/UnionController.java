package by.anne.controller;

import by.anne.model.entities.Union;
import by.anne.model.entities.UnionInCountry;
import by.anne.model.repositories.UnionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UnionController {


    private UnionRepository unionRepository;

    @GetMapping("/addUnion/{id}")
    public ModelAndView addBook(@PathVariable int id) {
        return new ModelAndView("add-union", "union", new UnionInCountry(id));
    }


    @Autowired
    public void setUnionRepository(UnionRepository unionRepository) {
        this.unionRepository = unionRepository;
    }


}
