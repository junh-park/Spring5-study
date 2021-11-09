package com.jun.tacos.web.api;

import java.util.Date;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import com.jun.tacos.Ingredient;
import com.jun.tacos.Taco;

import lombok.Getter;

public class TacoModel extends RepresentationModel<TacoModel> {
	
	@Getter
	private final String name;
	@Getter 
	private final Date createdAt;
	@Getter
	private final List<Ingredient> ingredients;

	public TacoModel(Taco taco) {
		super();
		this.name = taco.getName();
		this.createdAt = taco.getCreatedAt();
		this.ingredients = taco.getIngredients();
	}

}
