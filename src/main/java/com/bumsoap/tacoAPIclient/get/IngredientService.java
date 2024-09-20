package com.bumsoap.tacoAPIclient.get;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import tacos.Ingredient;

import java.util.HashMap;
import java.util.Map;

@Component
@AllArgsConstructor
public class IngredientService {
    private RestTemplate rest;

    public Ingredient getIngredientById(Long ingredientId) {
        Map<String, Long> urlVariables = new HashMap<>();

        urlVariables.put("id", ingredientId);

        return rest.getForObject("http://localhost:8080/data-api/ingredients/{id}",
                Ingredient.class, urlVariables);
    }
}
