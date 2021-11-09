package com.jun.tacos.web;

import javax.validation.Valid;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.jun.tacos.Order;
import com.jun.tacos.User;
import com.jun.tacos.data.OrderRepository;

@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
@ConfigurationProperties(prefix = "tacos.orders")
public class OrderController {
	
	private OrderRepository orderRepo;
	private int pageSize = 20;

	public OrderController(OrderRepository orderRepo) {
		this.orderRepo = orderRepo;
	}
	
	public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
	}

	@GetMapping("/current")
	public String orderForm(Model model) {
		return "orderForm";
	}
	
	@PostMapping
	public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus, 
			@AuthenticationPrincipal User user) {
		if(errors.hasErrors()) return "orderForm";
	
		order.setUser(user);
		
		orderRepo.save(order);
		sessionStatus.setComplete();
		
		return "redirect: /";
	}
	
	@PutMapping("/{orderId}")
	public Order putOrder(@RequestBody Order order) {
		return orderRepo.save(order);
	}
	
	@DeleteMapping("/{orderId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteOrder(@PathVariable("orderId") Long orderId) {
		try {
			orderRepo.deleteById(orderId);
		} catch (EmptyResultDataAccessException e) {
			
		}
	}
}

