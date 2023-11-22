package com.marketingapp1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marketingapp1.entity.Lead;
import com.marketingapp1.repository.LeadRepository;

@RestController 
@RequestMapping("/api/leads")
public class LeadRestController {
	
	@Autowired
	private LeadRepository leadRepo;
	
	
	//http://localhost:8080/api/leads
	@GetMapping //--> GetMapping convert java object to json object
	public List<Lead> getAllLeads()
	{
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}
	
	@PostMapping
	public void saveLeads(@RequestBody Lead lead)
	{
		leadRepo.save(lead);
	}
	
	//http://localhost:8080/api/leads/{id} --> path parameters
	//http://localhost:8080/api/leads?1 -->this is call Query parameters
	@PutMapping
	public void updateLeads(@RequestParam("id") long id, @RequestBody Lead lead)
	{
		lead.setId(id);
		leadRepo.save(lead);
	}
	
	@DeleteMapping
	public void deleteLead(@RequestParam("id") long id)
	{
		leadRepo.deleteById(id);
	}
}
