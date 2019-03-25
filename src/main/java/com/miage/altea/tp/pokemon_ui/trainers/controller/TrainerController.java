package com.miage.altea.tp.pokemon_ui.trainers.controller;

import com.miage.altea.tp.pokemon_ui.pokemonTypes.bo.PokemonType;
import com.miage.altea.tp.pokemon_ui.pokemonTypes.service.PokemonTypeService;
import com.miage.altea.tp.pokemon_ui.trainers.bo.Pokemon;
import com.miage.altea.tp.pokemon_ui.trainers.bo.Trainer;
import com.miage.altea.tp.pokemon_ui.trainers.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
@Controller
public class TrainerController {

    @Autowired
    TrainerService trainerService;

    @Autowired
    PokemonTypeService pokeTypeServ;


    @RequestMapping(value="/trainers")
    public ModelAndView trainers(){
        ModelAndView model = new ModelAndView();
        List<Trainer> listTrainer = trainerService.listTrainers();

        for(Trainer t : listTrainer) {
            List<PokemonType> listPokeType = new ArrayList<>();
            for (Pokemon p : t.getTeam()) {
                listPokeType.add(pokeTypeServ.getPokemonId(p.getPokemonType()));
            }
            t.setListPoke(listPokeType);
        }

        model.setViewName("trainers");
        model.addObject("trainers", listTrainer);
        return model;
    }

    public TrainerService getTrainerService() {
        return trainerService;
    }

    @Autowired
    public void setTrainerService(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @Autowired
    public void setPokeTypeService(PokemonTypeService pokeTypeServ) {
        this.pokeTypeServ = pokeTypeServ;
    }
}

