package com.miage.altea.tp.pokemon_ui.controller;

import com.miage.altea.tp.pokemon_ui.pokemonTypes.bo.PokemonType;
import com.miage.altea.tp.pokemon_ui.pokemonTypes.service.PokemonTypeService;
import com.miage.altea.tp.pokemon_ui.trainers.bo.Pokemon;
import com.miage.altea.tp.pokemon_ui.trainers.bo.Trainer;
import com.miage.altea.tp.pokemon_ui.trainers.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    TrainerService trainerService;

    @Autowired
    PokemonTypeService pokemonTypeService;

    SecurityContextHolder securityContextHolde;

    @GetMapping(value="/profile")
    public ModelAndView pokedex(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Trainer t = new Trainer();
        String currentUserName= "";

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }
        t = trainerService.getTrainer(currentUserName);

        List<PokemonType> listPokeType = new ArrayList<>();
        for (Pokemon p : t.getTeam()) {
            listPokeType.add(pokemonTypeService.getPokemonId(p.getPokemonType()));
        }
        t.setListPoke(listPokeType);

        ModelAndView model = new ModelAndView();
        model.setViewName("profile");
        model.addObject("trainer", t);
        model.addObject("pokemonTypes", t.getListPk());
        return model;
    }
}
