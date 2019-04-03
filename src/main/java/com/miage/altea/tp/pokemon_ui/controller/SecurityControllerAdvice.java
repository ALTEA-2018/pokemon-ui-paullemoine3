package com.miage.altea.tp.pokemon_ui.controller;

import com.miage.altea.tp.pokemon_ui.trainers.bo.Trainer;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class SecurityControllerAdvice {

        @ModelAttribute("user")
        Object principal(){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Object o = new Object();
            if (!(authentication instanceof AnonymousAuthenticationToken)) {
                o = authentication.getPrincipal();
            }
            return o;
        }

    @GetMapping(value="/navBar")
    public ModelAndView getNavbar(){
        ModelAndView model = new ModelAndView();
        model.setViewName("navBar");
        model.addObject("user", this.principal());
        return model;
    }
}
