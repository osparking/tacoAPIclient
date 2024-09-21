package com.bumsoap.tacoAPIclient.get;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;
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

}