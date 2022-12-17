package com.example.firstbackend;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class TestController {

	private final UserRepository userRepository;

	@GetMapping("/api/v1/user/{id}")
	public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
		return userRepository.findById(id).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/api/v1/user/all")
	public List<UserDto> getAll() {
		return userRepository.findAll();
	}
}
