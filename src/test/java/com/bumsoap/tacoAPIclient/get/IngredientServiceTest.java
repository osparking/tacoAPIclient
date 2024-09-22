package com.bumsoap.tacoAPIclient.get;

import jakarta.servlet.ServletException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestClientException;
import tacos.Ingredient;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class IngredientServiceTest {

    private IngredientService ingredientService;

    @Autowired
    public IngredientServiceTest(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @Test
    public void testIngredientPut() {
        Long ingId = 1L;
        Ingredient ingFromDB = ingredientService.getIngredientById(ingId);

        String ingName = "밀가루 또르띠아";
        ingFromDB.setName(ingName);
        ingredientService.updateIngredient(ingFromDB, ingId);

        assertEquals(ingredientService.getIngredientById(ingId).getName(), ingName);
    }

    @Test
    public void testIngredientName() {
        var ingredient = ingredientService.getIngredientById(1L);
        assertEquals(ingredient.getCode(), "FLTO");
    }

    @Test
    public void testIngredientDelete() {
        final long id = 5L;
        ingredientService.deleteIngredient(id);
        assertThrows(RestClientException.class,
                () -> ingredientService.getIngredientById(id),
                "RestClientException 이 발생하지 않음");
    }
    
}