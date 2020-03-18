package org.pharmacy.poc.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.pharmacy.poc.model.Employee;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CompanyControllerTest {

	private RestTemplate restTemplate;
	private HttpHeaders httpHeaders;
	@LocalServerPort
	private int port;
	@Mock
	private List<Employee> employees;

	@BeforeEach
	public void populateEmployee() {
		employees = new ArrayList<Employee>();
		employees.add(new Employee(1, null, null, null, null, null));
		employees.add(new Employee(2, null, null, null, null, null));
	}

	/**
	 * Here we test that we can create an employee using the POST method
	 */
	@DisplayName("PostMapping Controller Test")
	@Test
	public void testCreateEmployee() {
		try {
			restTemplate = new RestTemplate();
			HttpHeaders httpHeaders = createRequestBody();
			ObjectMapper Obj = new ObjectMapper();
			String jsonStr = Obj.writeValueAsString(employees);
			HttpEntity<String> request = new HttpEntity<>(jsonStr, httpHeaders);
			addBasicAuth(restTemplate);

			ResponseEntity<Employee[]> postResponse = restTemplate.postForEntity(getPostUrl(), request,
					Employee[].class);
			assertNotNull(postResponse);
			assertNotNull(postResponse.getBody());
		} catch (JsonProcessingException e) {

		}
	}

	private String getPostUrl() {
		String url = "http://localhost:" + port + "/company/employees-add";
		return url;
	}

	private HttpHeaders createRequestBody() {
		httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return httpHeaders;
	}

	@SuppressWarnings("deprecation")
	private void addBasicAuth(RestTemplate template) {
		template.getInterceptors().add(new BasicAuthorizationInterceptor("admin", "admin"));
	}

	/**
	 * Here we test that we can update an employee information using PUT method
	 */
	@DisplayName("PutMapping Company Controller Test")
	@Test
	public void testUpdateEmployee() {
		try {
			restTemplate = new RestTemplate();

			HttpHeaders httpHeaders = createRequestBody();
			ObjectMapper Obj = new ObjectMapper();
			String jsonStr = Obj.writeValueAsString(employees);
			HttpEntity<String> request = new HttpEntity<>(jsonStr, httpHeaders);
			addBasicAuth(restTemplate);

			restTemplate.put(getPutUrl(), request);
			assertNotNull(employees);
		} catch (JsonProcessingException ex) {

		}
	}

	private String getPutUrl() {
		String url = "http://localhost:" + port + "/company/employee-update";
		return url;
	}

	/**
	 * Here we test that we can fetch all employees
	 */
	@DisplayName("GetMapping Company Controller Test")
	@Test
	public void testListEmployee() {
		restTemplate = new RestTemplate();
		addBasicAuth(restTemplate);
		Employee[] userEntity = restTemplate.getForObject(getListUrl(), Employee[].class);
		assertNotNull(userEntity);
	}

	private String getListUrl() {
		String url = "http://localhost:" + port + "/company/employee-list";
		return url;
	}

	/**
	 * Here we test that we can delete an employee information using DELETE method
	 */
	@DisplayName("DeleteMapping Company Controller Test")
	@Test
	public void testDeleteEmployee() {
		try {
			restTemplate = new RestTemplate();

			HttpHeaders httpHeaders = createRequestBody();
			ObjectMapper Obj = new ObjectMapper();
			String jsonStr = Obj.writeValueAsString(employees);
			HttpEntity<String> request = new HttpEntity<>(jsonStr, httpHeaders);
			addBasicAuth(restTemplate);

			ResponseEntity<String> employees = restTemplate.exchange(getDeleteUrl(), HttpMethod.DELETE, request,
					String.class);
			assertNotNull(employees);
		} catch (JsonProcessingException ex) {

		}
	}

	private String getDeleteUrl() {
		String url = "http://localhost:" + port + "/company/employee-delete";
		return url;
	}
}
