package com.jun.tacos.web.api;


import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import com.jun.tacos.Taco;

public class TacoModelAssembler extends RepresentationModelAssemblerSupport<Taco, TacoModel>{

	public TacoModelAssembler() {
		super(DesignTacoController.class, TacoModel.class);
	}
	
	protected TacoModel instantiateModel(Taco taco) {
		return new TacoModel(taco);
	}
	
	public TacoModel toModel(Taco taco) {
		return createModelWithId(taco.getId(), taco);
	}

}
