package dev.sonnyjon.spring5recipe.services;

import dev.sonnyjon.spring5recipe.model.Recipe;

import java.util.Set;

/**
 * Created by Sonny on 5/31/2022.
 */
public interface RecipeService
{
    Set<Recipe> getRecipes();
}
