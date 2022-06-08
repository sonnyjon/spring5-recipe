package dev.sonnyjon.spring5recipe.controllers;

import dev.sonnyjon.spring5recipe.model.Recipe;
import dev.sonnyjon.spring5recipe.services.RecipeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Sonny on 6/8/2022.
 */
class RecipeControllerTest
{
    @Mock
    RecipeService service;

    RecipeController controller;
    AutoCloseable mocks;

    @BeforeEach
    void setUp()
    {
        mocks = MockitoAnnotations.openMocks(this);
        controller = new RecipeController(service);
    }

    @AfterEach
    void tearDown() throws Exception
    {
        mocks.close();
    }

    @Test
    void testGetRecipe() throws Exception
    {
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        when(service.findById(anyLong())).thenReturn(recipe);

        mockMvc.perform(get("/recipe/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/show"))
                .andExpect(model().attributeExists("recipe"));
    }
}