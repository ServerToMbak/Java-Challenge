package com.example.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.CompanyService;
import com.example.demo.core.utilities.DataResult;
import com.example.demo.entities.concretes.Company;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
	private CompanyService companyService;
	@Autowired
	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}
	@GetMapping("/getAll")
	public ResponseEntity<DataResult<List<Company>>> getAll()
	{
		return ResponseEntity.ok(companyService.getAll());
	}
	@GetMapping("/{companyId}")
	public ResponseEntity<DataResult<Company>> getById(@PathVariable int companyId)
	{
		return ResponseEntity.ok(companyService.get(companyId)); 
	}
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Company company){
		return ResponseEntity.ok(this.companyService.Add(company));
	}
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody Company company){
		return ResponseEntity.ok(this.companyService.Delete(company));
	}
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Company company){
		return ResponseEntity.ok(this.companyService.Update(company));
	}
}
