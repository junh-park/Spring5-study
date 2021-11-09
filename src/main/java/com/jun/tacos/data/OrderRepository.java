package com.jun.tacos.data;

import com.jun.tacos.Order;

public interface OrderRepository {
	Order save(Order order);
}
