package com.miage.altea.tp.pokemon_ui.pokemonTypes.service;

import com.miage.altea.tp.pokemon_ui.config.RestConfiguration;
import com.miage.altea.tp.pokemon_ui.pokemonTypes.bo.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
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
        var headers = new HttpHeaders();
        headers.setAcceptLanguageAsLocales(List.of(LocaleContextHolder.getLocale()));
        var httpRequest = new HttpEntity<>(headers);
        PokemonType[] listPoke;
        listPoke = rT.getForObject(this.pokemonServiceUrl+this.base_url, PokemonType[].class, httpRequest);
        List<PokemonType> listPT = Arrays.asList(listPoke);
        return listPT;
    }

    @Override
    public PokemonType getPokemonId(int id) {
        var headers = new HttpHeaders();
        headers.setAcceptLanguageAsLocales(List.of(LocaleContextHolder.getLocale()));
        var httpRequest = new HttpEntity<>(headers);
        PokemonType pokeType;
        pokeType = rT.getForObject(this.pokemonServiceUrl+this.base_url+id, PokemonType.class, httpRequest);
        return pokeType;
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
