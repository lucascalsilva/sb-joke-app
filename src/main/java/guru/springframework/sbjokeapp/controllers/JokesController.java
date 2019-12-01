package guru.springframework.sbjokeapp.controllers;

import guru.springframework.sbjokeapp.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class JokesController {

    private JokeService jokeService;

    @Autowired
    public JokesController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping
    public String getJoke(Model model){
        model.addAttribute("joke", jokeService.getRandomJoke());
        return "joke";
    }

}
