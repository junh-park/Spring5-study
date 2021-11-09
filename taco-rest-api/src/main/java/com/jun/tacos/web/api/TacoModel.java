package com.jun.tacos.web.api;

import java.util.Date;
import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.jun.tacos.Ingredient;
import com.jun.tacos.Taco;

import lombok.Getter;

@Relation(value = "taco", collectionRelation = "tacos")
public class TacoModel extends RepresentationModel<TacoModel> {
	private static final IngredientModelAssembler ingredientAssembler = new IngredientModelAssembler();
	
	@Getter
	private final String name;
	@Getter 
	private final Date createdAt;
	@Getter
	private final CollectionModel<IngredientModel> ingredients;

	public TacoModel(Taco taco) {
		super();
		this.name = taco.getName();
		this.createdAt = taco.getCreatedAt();
		this.ingredients = ingredientAssembler.toCollectionModel(taco.getIngredients());
	}

}
