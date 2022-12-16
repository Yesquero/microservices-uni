package com.example.firstbackend;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TestController {

	@GetMapping("/api/v1/user/{id}")
	public UserDto getUser(@PathVariable Long id) {

		UserDto userDto = new UserDto();
		userDto.setUserId(id);
		userDto.setName("Иван");

		return userDto;
	}

}
