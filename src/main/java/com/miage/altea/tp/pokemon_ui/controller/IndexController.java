package com.miage.altea.tp.pokemon_ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value="/")
public class IndexController {

    @GetMapping(value="/")
    public String index(){
        return "index";
    }

    @PostMapping(value="/registerTrainer")
    ModelAndView registerNewTrainer(@RequestBody String trainerName){
        ModelAndView model = new ModelAndView();
        model.setViewName("register");
        model.addObject("name", trainerName);
        return model;
    }

}
