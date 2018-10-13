package com.pv.recipejpa.service;

import com.pv.recipejpa.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
