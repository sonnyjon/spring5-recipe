package dev.sonnyjon.spring5recipe.services;

import dev.sonnyjon.spring5recipe.model.Recipe;
import dev.sonnyjon.spring5recipe.repos.RecipeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

/**
 * Created by Sonny on 6/4/2022.
 */
class RecipeServiceImplTest
{
    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    void getRecipes()
    {
        Recipe recipe = new Recipe();
        HashSet data = new HashSet();
        data.add(recipe);

        when(recipeRepository.findAll()).thenReturn(data);

        Set<Recipe> recipes = recipeService.getRecipes();
        Assertions.assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
    }
}