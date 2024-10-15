package be.digitalycity.java.bxl_java24_demospringmvc.pl.controllers;

import be.digitalycity.java.bxl_java24_demospringmvc.dl.model.Director;
import be.digitalycity.java.bxl_java24_demospringmvc.dl.model.Film;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class FilmController {

    Director dir1 = new Director(1, "David", "Cronenberg");
    Director dir2 = new Director(2, "James", "Cameron");
    Director dir3 = new Director(3, "Stanley", "Kubrick");

    private List<Film> films = List.of(
            new Film(1, "Children Of Men", dir1),
            new Film(2, "Civil War", dir2),
            new Film(3, "Lord od the Rings", dir3)
    );

    @GetMapping("/films")
    public String getOne(
            @PathVariable Long id,
            Model model
    ) {
        String sentence = "Here is your film list : ";
        model.addAttribute("sentence", sentence);
        return "films";
    }

    @GetMapping("/film/{id}")
    public String film(
            @PathVariable
            int id,
            Model model
    ) {
        if(id >= 0 && id < films.size()) {
            String sentence = "Here is your film : " + films.get(id);
            model.addAttribute("sentence", sentence);
            return "film";
        }
        else {
            return "error404";
        }
    }
}
