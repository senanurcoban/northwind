package com.kodlamaio.northwind.business.abstracts;


import java.util.List;

import com.kodlamaio.northwind.business.requests.CreateOrderRequest;
import com.kodlamaio.northwind.business.responses.CreateOrderResponse;
import com.kodlamaio.northwind.business.responses.GetAllOrdersResponse;
import com.kodlamaio.northwind.business.responses.GetOrderResponse;

public interface OrderService {
	

	List<GetAllOrdersResponse> getAll();
	CreateOrderResponse add(CreateOrderRequest createOrderRequest);
	
	GetOrderResponse getById(int id);
	
	
	
}
