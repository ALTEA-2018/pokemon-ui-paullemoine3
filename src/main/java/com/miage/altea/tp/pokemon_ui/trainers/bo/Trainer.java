package com.miage.altea.tp.pokemon_ui.trainers.bo;

import com.miage.altea.tp.pokemon_ui.pokemonTypes.bo.PokemonType;
import java.util.List;

public class Trainer {

    private String name;

    private List<Pokemon> team;

    private List<PokemonType> listPk;

    private String password;

    public Trainer() {
    }

    public Trainer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pokemon> getTeam() {
        return team;
    }

    public void setTeam(List<Pokemon> team) {
        this.team = team;
    }

    public void setListPoke(List<PokemonType> listPkType) { this.listPk = listPkType;}

    public List<PokemonType> getListPk(){return this.listPk;}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
