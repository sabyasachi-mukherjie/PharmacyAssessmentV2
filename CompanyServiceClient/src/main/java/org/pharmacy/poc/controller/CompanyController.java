package org.pharmacy.poc.controller;

import java.util.List;

import javax.validation.Valid;

import org.pharmacy.poc.model.Employee;
import org.pharmacy.poc.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CompanyService service;

	@PostMapping(value = "/company/employees-add")
	public List<Employee> addEmployee(@RequestBody @Valid List<Employee> employees) {
		log.info("Saving empoyee information for future use.");
		return service.save(employees);
	}

}
