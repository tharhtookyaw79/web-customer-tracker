package com.beyondasync.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.beyondasync.springdemo.entity.Customer;
import com.beyondasync.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject the customer service
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {

		// 1. get customers from the dao
		// 2. add the customer to the model

		List<Customer> theCustomers = customerService.getCustomers();
		theModel.addAttribute("customers", theCustomers);

		return "list-customers";
	}

}
