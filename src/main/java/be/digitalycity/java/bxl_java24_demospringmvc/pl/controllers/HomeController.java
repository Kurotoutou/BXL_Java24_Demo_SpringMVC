package be.digitalycity.java.bxl_java24_demospringmvc.pl.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    //quand je contact mon serveur à l'url http://localhost:8080/
    // il me retourne le contenus du fichier home.html (situé dans templates)
    @GetMapping("/")// url comment l'app contact le server
    public String home() {
        return "home"; // path vers html file location (return du contenu html depuis template)
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name, Model model) { // model bind les données à la vue (c'est une map)
        String sentence = "Hello " + name + " !";
        model.addAttribute("sentence", sentence);
        return"hello";
    }

}
