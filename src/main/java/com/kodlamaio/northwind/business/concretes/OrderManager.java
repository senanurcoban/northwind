package com.kodlamaio.northwind.business.concretes;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.northwind.business.abstracts.OrderService;
import com.kodlamaio.northwind.business.requests.CreateOrderRequest;
import com.kodlamaio.northwind.business.responses.CreateOrderResponse;
import com.kodlamaio.northwind.business.responses.GetAllOrdersResponse;
import com.kodlamaio.northwind.business.responses.GetOrderResponse;
import com.kodlamaio.northwind.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.northwind.dataAccess.abstracts.OrderRepository;
import com.kodlamaio.northwind.entities.Employee;
import com.kodlamaio.northwind.entities.Order;
@Service
public class OrderManager implements OrderService{

	private OrderRepository orderRepository;
	private ModelMapperService modelMapperService;
	@Autowired
	public OrderManager(OrderRepository orderRepository) {
		this.orderRepository=orderRepository;
	}
	@Override
	public List<GetAllOrdersResponse> getAll() {
		List<Order> orders=orderRepository.findAll();
		List<GetAllOrdersResponse> ordersResponse=new ArrayList<GetAllOrdersResponse>();
		for(Order order:orders) {
			GetAllOrdersResponse responseItem=new GetAllOrdersResponse();
			responseItem.setId(order.getId());
			responseItem.setDate(order.getDate());
			
			ordersResponse.add(responseItem);
		}
		return ordersResponse;
	}

	@Override
	public CreateOrderResponse add(CreateOrderRequest createOrderRequest) {
		
		Order order=this.modelMapperService.forRequest().map(createOrderRequest,Order.class);
		this.orderRepository.save(order);
		CreateOrderResponse orderResponse=this.modelMapperService.forResponse().map(order,CreateOrderResponse.class);
		return orderResponse;
		
		
		
		
		/*Order order=new Order();
		order.setDate(createOrderRequest.getDate());
		this.orderRepository.save(order);*/
		
	}
	@Override
	public GetOrderResponse getById(int id) {
		GetOrderResponse getOrderResponse=new GetOrderResponse();
		Order order=this.orderRepository.findById(id).get();
		getOrderResponse.setId(order.getId());		
		getOrderResponse.setDate(order.getDate());
		
		Employee employee=new Employee();
		employee.setId(order.getEmployee().getId());
		getOrderResponse.setEmployeeId(employee.getId());
	    
		return getOrderResponse;
	}
	
 
	
	
}
