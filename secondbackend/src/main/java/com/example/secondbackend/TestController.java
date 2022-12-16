package com.example.secondbackend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
public class TestController {

	@GetMapping("/api/v1/posts")
	public List<PostDto> getPosts(@RequestParam Long userId) {
		PostDto postDto = new PostDto();
		postDto.setUuid(UUID.randomUUID());
		postDto.setUserId(userId);
		postDto.setTitle("First title");
		postDto.setBody("Body");
		return Collections.singletonList(postDto);
	}

	@GetMapping("/api/v1/posts/comments")
	public List<CommentDto> getComments() {
		return List.of(new CommentDto(UUID.randomUUID(), "First comment"), new CommentDto(UUID.randomUUID(),"Second comment"));
	}

}
