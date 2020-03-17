package org.pharmacy.poc.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.pharmacy.poc.model.User;
import org.pharmacy.poc.repository.UserRepository;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

	@InjectMocks
	private UserService userService;
	@Mock
	private UserRepository userRepository;
	@Mock
	private User user;

	@DisplayName("PostMapping Service Test")
	@Test
	void testCreateUser() {
		assertNotNull(userService.save(user));
	}

	@DisplayName("PutMapping Service Test")
	@Test
	void testUpdateUser() {
		assertNotNull(userService.update(user));
	}

}
