package com.miage.altea.tp.pokemon_ui.controller;

import com.miage.altea.tp.pokemon_ui.pokemonTypes.bo.PokemonType;
import com.miage.altea.tp.pokemon_ui.pokemonTypes.service.PokemonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class PokemonTypeController {

    PokemonTypeService pokemonTypeService;

    @GetMapping(value="/pokedex")
    public ModelAndView pokedex(){
        ModelAndView model = new ModelAndView();
        List<PokemonType> listPT = pokemonTypeService.listPokemonsTypes();
        model.setViewName("pokedex");
        model.addObject("pokemonTypes", listPT);
        return model;
    }

    public PokemonTypeService getPokeTypeServ() {
        return pokemonTypeService;
    }

    @Autowired
    public void setPokemonTypeService(PokemonTypeService pokeTypeServ) {
        this.pokemonTypeService = pokeTypeServ;
    }
}
