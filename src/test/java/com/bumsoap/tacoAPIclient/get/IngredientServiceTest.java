package com.bumsoap.tacoAPIclient.get;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class IngredientServiceTest {

    private IngredientService ingredientService;

    @Autowired
    public IngredientServiceTest(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @Test
    public void testIngredientName() {
        var ingredient = ingredientService.getIngredientById(1L);
        assertEquals(ingredient.getCode(), "FLTO");
    }

}