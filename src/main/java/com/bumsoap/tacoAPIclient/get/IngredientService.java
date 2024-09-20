package com.bumsoap.tacoAPIclient.get;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import tacos.Ingredient;

@Component
@AllArgsConstructor
public class IngredientService {
    private RestTemplate rest;

    public Ingredient getIngredientById(Long ingredientId) {
        return rest.getForObject("http://localhost:8080/data-api/ingredients/{id}",
                Ingredient.class, ingredientId);
    }
}
