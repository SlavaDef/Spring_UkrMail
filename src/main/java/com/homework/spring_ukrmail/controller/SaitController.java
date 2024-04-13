package com.homework.spring_ukrmail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static com.homework.spring_ukrmail.utils.Constants.EXANGE;

@Controller
public class SaitController {

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute( "title", EXANGE);
        return "about";
    }

    @GetMapping("/home")
    public String mainTittle(Model model) {
        model.addAttribute( "title", "Hello");
        return "home";
    }

    @GetMapping("/posts")
    public String post() {
        return "redirect:https://www.work.ua/articles/expert-opinion/2602/";
    }

    @GetMapping("/sait")
    public String sait() {
        return "redirect:https://senior-pomidor.com.ua/";
    }

}
