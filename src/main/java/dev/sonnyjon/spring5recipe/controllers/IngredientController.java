package dev.sonnyjon.spring5recipe.controllers;

import dev.sonnyjon.spring5recipe.commands.IngredientCommand;
import dev.sonnyjon.spring5recipe.services.IngredientService;
import dev.sonnyjon.spring5recipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Sonny on 6/10/2022.
 */
@Slf4j
@Controller
public class IngredientController
{
    private final RecipeService recipeService;
    private final IngredientService ingredientService;

    public IngredientController(RecipeService recipeService, IngredientService ingredientService)
    {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }

    @GetMapping
    @RequestMapping("/recipe/{recipeId}/ingredients")
    public String listIngredients(@PathVariable String recipeId, Model model)
    {
        log.debug("Getting ingredient list for recipe id: " + recipeId);

        // use command object to avoid lazy load errors in Thymeleaf.
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(recipeId)));
        return "recipe/ingredient/list";
    }

    @GetMapping
    @RequestMapping("recipe/{recipeId}/ingredient/{id}/show")
    public String showRecipeIngredient(@PathVariable String recipeId,
                                       @PathVariable String id,
                                       Model model)
    {
        IngredientCommand ingredient = ingredientService.findByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(id));
        model.addAttribute("ingredient", ingredient);
        return "recipe/ingredient/show";
    }
}