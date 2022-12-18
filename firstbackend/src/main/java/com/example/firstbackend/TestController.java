package com.example.firstbackend;

import com.example.firstbackend.dto.UserBasicDto;
import com.example.firstbackend.dto.UserFullDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final UserRepository userRepository;

    @GetMapping("/api/v1/user/{id}")
    public ResponseEntity<UserBasicDto> getUser(@PathVariable Long id) {
        return userRepository.findById(id).map(user -> ResponseEntity.ok(user.toBasicDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/api/v1/user/all")
    public List<UserBasicDto> getAll() {
        return userRepository.findAll().stream().map(UserDto::toBasicDto).toList();
    }

    @GetMapping("/api/v1/user/{id}/full")
    public ResponseEntity<UserFullDto> getFullInfo(@PathVariable Long id) {
        return userRepository.findById(id).map(user -> ResponseEntity.ok(user.toDto()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
