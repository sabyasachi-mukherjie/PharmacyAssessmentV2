package org.pharmacy.poc.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.pharmacy.poc.model.Employee;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@SpringBootTest
public class CompanyServiceTest {

	@InjectMocks
	private CompanyService service;
	@Mock
	private List<Employee> employees;
	@Mock
	private DiscoveryClient discoveryClient;

	@BeforeEach
	public void populateEmployee() {
		employees = new ArrayList<Employee>();
		employees.add(new Employee(1, "company test first name", "company test last name", "company test address",
				"company test telephone", "company test email"));
		employees.add(new Employee(2, "company test first name", "company test last name", "company test address",
				"company test telephone", "company test email"));
	}

	@DisplayName("PostMapping Company Service Test")
	@Test
	void testCreateUser() {
		assertNotNull(service.save(employees));
	}

	@DisplayName("PutMapping Company Service Test")
	@Test
	void testUpdateUser() {
		assertNotNull(service.update(employees));
	}

	@DisplayName("GetMapping Company Service Test")
	@Test
	void testListAllUsers() {
		assertNotNull(service.listEmployee("firstname,lastname", "1", "1"));
	}

	@DisplayName("DeleteMapping Company Service Test")
	@Test
	void testDeleteUser() {
		assertNotNull(service.delete(employees));
	}

}
