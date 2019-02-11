package com.miage.altea.tp.pokemon_ui.pokemonTypes.service;

import com.miage.altea.tp.pokemon_ui.config.RestConfiguration;
import com.miage.altea.tp.pokemon_ui.pokemonTypes.bo.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {


    String pokemonServiceUrl;

    String base_url = "/pokemon-types/";

    RestTemplate rT;

    @Override
    public List<PokemonType> listPokemonsTypes() {
        PokemonType[] listPoke;
        listPoke = rT.getForObject(this.pokemonServiceUrl+this.base_url, PokemonType[].class);
        List<PokemonType> listPT = Arrays.asList(listPoke);
        return listPT;
    }

    @Autowired
    @Override
    public void setRestTemplate(RestTemplate restTemplate) {
        rT= restTemplate;
    }

    @Override
    @Value("${pokemonType.service.url}")
    public void setPokemonTypeServiceUrl(String pokemonServiceUrl) {
        this.pokemonServiceUrl= pokemonServiceUrl;
    }
}
