package com.pv.recipejpa.controller;

import com.pv.recipejpa.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    private final RecipeService recipeService;

    public HomeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping({"/index", "", "/"})
    public String getRecipes(Model model){
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
