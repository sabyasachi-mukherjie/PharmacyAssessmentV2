package org.pharmacy.poc.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.json.JSONObject;
import org.pharmacy.poc.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

@Service
public class CompanyService {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	DiscoveryClient discoveryClient;
	@Autowired
	HttpHeaders httpHeaders;

	public CompanyService() {
		// Default Constructor
	}

	@SuppressWarnings("deprecation")
	public List<Employee> save(List<Employee> employees) {
		List<Employee> employeesAdded = new ArrayList<>();
		List<ServiceInstance> svcInstances = discoveryClient.getInstances("employee-service");
		ServiceInstance employeeService = null;
		if (!svcInstances.isEmpty()) {
			employeeService = svcInstances.get(0);
			String url = "http://" + employeeService.getHost() + ":" + employeeService.getPort() + "/" + "user/save";
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			if (null != employees && !employees.isEmpty()) {
				for (Employee employee : employees) {
					JSONObject jsonObj = new JSONObject(employee);
					HttpEntity<String> request = new HttpEntity<>(jsonObj.toString(), httpHeaders);
					restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("admin", "admin"));
					employeesAdded.add(restTemplate.postForObject(url, request, Employee.class));
				}
			}
		}
		return employeesAdded;
	}

	@SuppressWarnings("deprecation")
	public List<Employee> update(@Valid List<Employee> employees) {
		List<ServiceInstance> svcInstances = discoveryClient.getInstances("employee-service");
		ServiceInstance employeeService = null;
		if (!svcInstances.isEmpty()) {
			employeeService = svcInstances.get(0);
			String url = "http://" + employeeService.getHost() + ":" + employeeService.getPort() + "/" + "user/save";
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			if (null != employees && !employees.isEmpty()) {
				for (Employee employee : employees) {
					JSONObject jsonObj = new JSONObject(employee);
					HttpEntity<String> request = new HttpEntity<>(jsonObj.toString(), httpHeaders);
					restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("admin", "admin"));
					restTemplate.put(url, request);
				}
			}
		}
		return employees;
	}

}
