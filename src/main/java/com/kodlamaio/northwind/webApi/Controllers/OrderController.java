package com.kodlamaio.northwind.webApi.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.northwind.business.abstracts.OrderService;
import com.kodlamaio.northwind.business.requests.CreateOrderRequest;
import com.kodlamaio.northwind.business.responses.GetAllOrdersResponse;
import com.kodlamaio.northwind.business.responses.GetOrderResponse;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	private OrderService orderService;
	
	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService=orderService;
	}
	@GetMapping("/getall")
	public List<GetAllOrdersResponse> getAll(){
		return orderService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody() CreateOrderRequest createOrderRequest) {
		this.orderService.add(createOrderRequest);
	}
     @GetMapping("/getbyid")
    public GetOrderResponse getById(int id){
    	 return orderService.getById(id);
     } 
    
}
