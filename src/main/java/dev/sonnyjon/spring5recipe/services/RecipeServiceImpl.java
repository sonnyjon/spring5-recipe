package dev.sonnyjon.spring5recipe.services;

import dev.sonnyjon.spring5recipe.model.Recipe;
import dev.sonnyjon.spring5recipe.repos.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by Sonny on 5/31/2022.
 */
@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService
{
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository)
    {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes()
    {
        log.debug("I'm in the service");

        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Recipe findById(Long id)
    {
        Optional<Recipe> optional = recipeRepository.findById(id);

        if (optional.isEmpty()) throw new RuntimeException("Recipe Not Found!");

        return optional.get();
    }
}
