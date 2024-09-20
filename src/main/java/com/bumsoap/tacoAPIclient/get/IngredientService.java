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

    public Ingredient getIngredientById(Long ingredientId) {
        ResponseEntity<Ingredient> responseEntity =
                rest.getForEntity("http://localhost:8080/data-api/ingredients/{id}",
                        Ingredient.class, ingredientId);
        var date = responseEntity.getHeaders().getDate();
        var ldt = Instant.ofEpochMilli(date).atZone(ZoneId.systemDefault()).toLocalDateTime();
        log.info("자료 읽은 시각: {}", ldt);
        return responseEntity.getBody();
    }
}
