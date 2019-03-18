package com.miage.altea.tp.pokemon_ui.trainers.service;

import com.miage.altea.tp.pokemon_ui.trainers.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {

    String trainerServiceUrl;

    String base_url = "/trainers/";

    RestTemplate rT;

    @Override
    @Cacheable(value = "trainers")
    public List<Trainer> listTrainers() {
        var headers = new HttpHeaders();
        headers.setAcceptLanguageAsLocales(List.of(LocaleContextHolder.getLocale()));
        var httpRequest = new HttpEntity<>(headers);
        Trainer[] listTrainer;
        listTrainer = rT.getForObject(this.trainerServiceUrl+this.base_url, Trainer[].class, httpRequest);
        List<Trainer> listTrainers = Arrays.asList(listTrainer);
        return listTrainers;
    }

    @Override
    public Trainer getTrainer(String name){
        Trainer trainer;
        trainer = rT.getForObject(this.trainerServiceUrl+this.base_url+"{name}", Trainer.class, name);
        return trainer;
    }

    @Autowired
    @Override
    @Qualifier("trainerApiRestTemplate")
    public void setRestTemplate(RestTemplate restTemplate) {
        rT= restTemplate;
    }

    @Override
    @Value("${trainer.service.url}")
    public void setTrainerServiceUrl(String trainerService) {
        this.trainerServiceUrl= trainerService;
    }


}
