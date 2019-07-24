package com.oropezabooks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oropezabooks.dao.CustomerDAO;
import com.oropezabooks.entity.Customer;
import com.oropezabooks.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
//	@RequestMapping("/list")
	@GetMapping("/list")
	public String customerList(Model theModel) {
		
		List<Customer> customers = customerService.getCustomers();
		
		theModel.addAttribute("customers", customers);
		
		return "customer-list";
	}
	
	@GetMapping("/showForm")
	public String showForm(Model theModel) {
		
		Customer newCustomer = new Customer();
		
		theModel.addAttribute("customer", newCustomer);
		
		return "showForm";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer newCostumer ) {
		
		customerService.saveCustomer(newCostumer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/editForm")
	public String editForm(@RequestParam("customerId") int customerId, Model theModel) {
		
		Customer toEdit = customerService.getCustomer(customerId);
		
		theModel.addAttribute("customer", toEdit);
		
		
		
		return "editForm";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int customerId) {
		
		customerService.deleteCustomer(customerId);
		
		return "redirect:/customer/list";
	}
	
}
