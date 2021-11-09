package com.jun.tacos.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.jun.tacos.Order;
import com.jun.tacos.data.CrudOrderRepository;

@Controller
@RequestMapping("/orders")
public class OrderController {
	
	private CrudOrderRepository orderRepo;

	public OrderController(CrudOrderRepository orderRepo) {
		this.orderRepo = orderRepo;
	}

	@GetMapping("/current")
	public String orderForm(Model model) {
		return "orderForm";
	}
	
	@PostMapping
	public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus) {
		if(errors.hasErrors()) return "orderForm";
		orderRepo.save(order);
		sessionStatus.setComplete();
		return "redirect: /";
	}
}
