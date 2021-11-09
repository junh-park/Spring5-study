package com.jun.tacos.data;

import org.springframework.data.repository.CrudRepository;

import com.jun.tacos.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
