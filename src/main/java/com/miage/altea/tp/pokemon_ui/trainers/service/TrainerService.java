package com.miage.altea.tp.pokemon_ui.trainers.service;

import com.miage.altea.tp.pokemon_ui.trainers.bo.Trainer;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public interface TrainerService {

    public List<Trainer> listTrainers();
    public void setRestTemplate(RestTemplate restTemplate);
    public void setTrainerServiceUrl(String trainerService);

}
