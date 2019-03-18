package com.miage.altea.tp.pokemon_ui.trainers.service;

import com.miage.altea.tp.pokemon_ui.trainers.bo.Trainer;
import com.miage.altea.tp.pokemon_ui.trainers.bo.TrainerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TrainerDetailsImpl implements UserDetailsService {

    @Autowired
    TrainerService trainerService;

    public void setTrainerService(TrainerService trainer){
        this.trainerService = trainer;
    }

    public TrainerService getTrainerService(){
        return this.trainerService;
    }

    @Override
    public TrainerDetails loadUserByUsername(String s) throws UsernameNotFoundException, BadCredentialsException

    {
        TrainerDetails trainerDetails = new TrainerDetails();
        Trainer t = trainerService.getTrainer(s);
        if(t != null) {
            trainerDetails.setTrainer(t);
            return trainerDetails;
        }else {
            throw new BadCredentialsException("No such user");
        }
    }
}
