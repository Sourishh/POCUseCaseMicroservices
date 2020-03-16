package com.example.sourish.client.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.user.UserRepository;

@SpringBootTest
public class UserClientRegistryTest {

	@Autowired
	UserRepository userRepository;


	@Test
	void testGet()
	{
		assertEquals("Hello Junit 5", userRepository.findAll());
	}

}
