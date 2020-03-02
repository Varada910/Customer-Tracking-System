package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.dao.CustomerDAO;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//inject DAO in this controller using DI @Autowired
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model)
	{
		
		//get customers from DAO
		List<Customer> theCustomers=customerService.getCustomers();
		
		System.out.println(theCustomers);
		
		//Add them to model object
		
		model.addAttribute("customers", theCustomers);
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model)
	{
		Customer newCustomer=new Customer();
		model.addAttribute("customer",newCustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer)
	{
		
		customerService.saveCustomer(theCustomer);
		//Call the CustomerService method
		return "redirect:/customer/list";
}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel)
	{
		
		Customer customer=customerService.getCustomer(theId);
		
		theModel.addAttribute("customer",customer);
		
		return "customer-form" ;
}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId)
	{
		
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
		
}
	
	
}
