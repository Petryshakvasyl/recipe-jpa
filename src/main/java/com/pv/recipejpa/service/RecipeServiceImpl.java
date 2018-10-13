package com.pv.recipejpa.service;

import com.pv.recipejpa.domain.Recipe;
import com.pv.recipejpa.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
       HashSet<Recipe> recipes = new HashSet<>();
       recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
       return  recipes;
    }
}
