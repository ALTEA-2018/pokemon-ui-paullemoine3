package com.miage.altea.tp.pokemon_ui.config;

import com.miage.altea.tp.pokemon_ui.trainers.bo.TrainerDetails;
import com.miage.altea.tp.pokemon_ui.trainers.service.TrainerDetailsImpl;
import com.miage.altea.tp.pokemon_ui.trainers.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    TrainerService trainerService;

    public void setTrainerService(TrainerService trainerService){
        this.trainerService = trainerService;
    }

    public TrainerDetailsImpl userDetailsService() {
        TrainerDetailsImpl tDI = new TrainerDetailsImpl();
        tDI.setTrainerService(trainerService);
        return tDI;
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
