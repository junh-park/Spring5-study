package com.jun.tacos.web.api;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.jun.tacos.Taco;
import com.jun.tacos.data.TacoRepository;

@RepositoryRestController
public class RecentTacosController {
	private TacoRepository tacoRepo;

	public RecentTacosController(TacoRepository tacoRepo) {
		this.tacoRepo = tacoRepo;
	}

	@GetMapping
	public ResponseEntity<CollectionModel<TacoModel>> recentTacos() {
		PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());
		List<Taco> tacos = tacoRepo.findAll(page).getContent();
		
		CollectionModel<TacoModel> recentTacos = new TacoModelAssembler().toCollectionModel(tacos);
		recentTacos.add(WebMvcLinkBuilder.linkTo(
				WebMvcLinkBuilder.methodOn(RecentTacosController.class).recentTacos()).withRel("recents"));
		return new ResponseEntity<>(recentTacos, HttpStatus.OK);
	}
}
