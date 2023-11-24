package by.anne.controller;

import by.anne.model.entities.Union;
import by.anne.model.repositories.UnionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class UnionController {


    private UnionRepository unionRepository;



    @Autowired
    public void setUnionRepository(UnionRepository unionRepository) {
        this.unionRepository = unionRepository;
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        List<Union> unions = unionRepository.getAllUnions(id);
        model.addAttribute("unions", unions);
        return "country";


    }
}
