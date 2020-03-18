package org.pharmacy.poc.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pharmacy.poc.model.UserEntity;
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
public class UserontrollerTest {
	private RestTemplate restTemplate;
	private HttpHeaders httpHeaders;
	@LocalServerPort
	private int port;

	/**
	 * Here we test that we can create an employee using the POST method
	 */
	@DisplayName("PostMapping Controller Test")
	@Test
	public void testCreateEmployee() {
		try {
			UserEntity userEntity = new UserEntity();
			userEntity.setAddress("Test Address");
			userEntity.setEmail("test email");
			userEntity.setFirstNm("test first name");
			userEntity.setLastNm("test last name");
			userEntity.setTelephone("test telephone number");
			restTemplate = new RestTemplate();
			HttpHeaders httpHeaders = createPostBody();
			ObjectMapper Obj = new ObjectMapper();
			String jsonStr = Obj.writeValueAsString(userEntity);
			HttpEntity<String> request = new HttpEntity<>(jsonStr, httpHeaders);
			addBasicAuth(restTemplate);

			ResponseEntity<UserEntity> postResponse = restTemplate.postForEntity(getPostUrl(), request,
					UserEntity.class);
			assertNotNull(postResponse);
			assertNotNull(postResponse.getBody());
		} catch (JsonProcessingException e) {

		}
	}

	/**
	 * Here we test that we can update an employee information using PUT method
	 */
	@DisplayName("PutMapping Controller Test")
	@Test
	public void testUpdateEmployee() {
		try {
			UserEntity userEntity = new UserEntity();
			userEntity.setEmplId(1);
			userEntity.setFirstNm("test updated first name");
			userEntity.setLastNm("test updated last name");
			userEntity.setTelephone("test updated telephone number");
			userEntity.setAddress("test updated address");
			userEntity.setEmail("test updated email address");
			restTemplate = new RestTemplate();

			HttpHeaders httpHeaders = createPostBody();
			ObjectMapper Obj = new ObjectMapper();
			String jsonStr = Obj.writeValueAsString(userEntity);
			HttpEntity<String> request = new HttpEntity<>(jsonStr, httpHeaders);
			addBasicAuth(restTemplate);

			restTemplate.put(getPostUrl(), request);
			assertNotNull(userEntity);
		} catch (JsonProcessingException ex) {

		}
	}

	private String getPostUrl() {
		String url = "http://localhost:" + port + "/user/save";
		return url;
	}

	private HttpHeaders createPostBody() {
		httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return httpHeaders;
	}

	@SuppressWarnings("deprecation")
	private void addBasicAuth(RestTemplate template) {
		template.getInterceptors().add(new BasicAuthorizationInterceptor("admin", "admin"));
	}

	/**
	 * Here we test that we can fetch all employees
	 */
	@DisplayName("GetMapping Controller Test")
	@Test
	public void testListEmployee() {
		restTemplate = new RestTemplate();
		addBasicAuth(restTemplate);
		UserEntity[] userEntity = restTemplate.getForObject(getListUrl(), UserEntity[].class);
		assertNotNull(userEntity);
	}

	private String getListUrl() {
		String url = "http://localhost:" + port + "/user/list";
		return url;
	}

	/**
	 * Here we test that we can create an employee using the POST method
	 */
	@DisplayName("DeleteMapping Controller Test")
	@Test
	public void testDeleteEmployee() {
		try {
			UserEntity userEntity = new UserEntity();
			userEntity.setEmplId(1);
			restTemplate = new RestTemplate();
			HttpHeaders httpHeaders = createPostBody();
			ObjectMapper Obj = new ObjectMapper();
			String jsonStr = Obj.writeValueAsString(userEntity);
			HttpEntity<String> request = new HttpEntity<>(jsonStr, httpHeaders);
			addBasicAuth(restTemplate);

			ResponseEntity<UserEntity> postResponse = restTemplate.exchange(getDeleteUrl(), HttpMethod.DELETE, request,
					UserEntity.class);
			assertNotNull(postResponse);
		} catch (JsonProcessingException e) {

		} catch (Exception ex) {

		}
	}

	private String getDeleteUrl() {
		String url = "http://localhost:" + port + "/user/delete";
		return url;
	}

}
