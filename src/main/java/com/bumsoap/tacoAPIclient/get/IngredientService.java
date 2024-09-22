package com.bumsoap.tacoAPIclient.get;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import tacos.Ingredient;

import java.time.Instant;
import java.time.ZoneId;

@Component
@AllArgsConstructor
@Slf4j
public class IngredientService {
    private RestTemplate rest;

    @SuppressWarnings("unused")
    public void deleteIngredient(Long id) {
        rest.delete("http://localhost:8080/data-api/ingredients/{id}", id);
    }

    public void updateIngredient(Ingredient ingredient, Long id) {
        rest.put("http://localhost:8080/data-api/ingredients/{id}",
                ingredient, id);
    }

    public Ingredient createIngredient(Ingredient ingredient) {
        ResponseEntity<Ingredient> responseEntity =
                rest.postForEntity("http://localhost:8080/data-api/ingredients",
                        ingredient, Ingredient.class);
        log.info("새 재료 장소: {}", responseEntity.getHeaders().getLocation());
        return responseEntity.getBody();
    }

    public Ingredient getIngredientById(Long ingredientId) {
        ResponseEntity<Ingredient> responseEntity =
                rest.getForEntity("http://localhost:8080/data-api/ingredients/{id}",
                        Ingredient.class, ingredientId);
        var date = responseEntity.getHeaders().getDate();
        var ldt = Instant.ofEpochMilli(date).atZone(ZoneId.systemDefault()).toLocalDateTime();
        log.info("자료 읽은 시각: {}", ldt);
        return responseEntity.getBody();
    }

    public Ingredient getIngredientByCode(String code) {
        ResponseEntity<Ingredient> responseEntity =
                rest.getForEntity("http://localhost:8080/ingredient?code={code}",
                        Ingredient.class, code);
        var ingredient = responseEntity.getBody();
        return ingredient;
    }
}
