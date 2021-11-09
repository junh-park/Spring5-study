package com.jun.tacos.data;

import com.jun.tacos.Ingredient;

public interface IngredientRepository {
	public Iterable<Ingredient> findAll();
	public Ingredient findOne(String id);
	public Ingredient save(Ingredient ingredient);
}
