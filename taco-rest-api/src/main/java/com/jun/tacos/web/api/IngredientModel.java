package com.jun.tacos.web.api;

import org.springframework.hateoas.RepresentationModel;

import com.jun.tacos.Ingredient;
import com.jun.tacos.Ingredient.Type;

import lombok.Getter;

public class IngredientModel extends RepresentationModel<IngredientModel> {
	@Getter
	private String name;
	@Getter
	private Type type;

	public IngredientModel(Ingredient ingredient) {
		this.name = ingredient.getName();
		this.type = ingredient.getType();
	}

}
