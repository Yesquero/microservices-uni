package com.example.secondbackend;

import com.example.secondbackend.dto.CommentDto;
import com.example.secondbackend.dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class TestController {

	private final PostRepository postRepository;
	private final CommentRepository commentRepository;

	@GetMapping("/api/v1/posts/all")
	public List<PostDto> getAll() {
		return postRepository.findAll().stream().map(Post::toDto).toList();
	}

	@GetMapping("/api/v1/posts/")
	public List<PostDto> getPosts(@RequestParam Long userId) {
		return postRepository.findPostByUserId(userId).stream().map(Post::toDto).toList();
	}

	@GetMapping("/api/v1/posts/{postUuid}/comments")
	public ResponseEntity<List<CommentDto>> getComments(@PathVariable UUID postUuid) {
		return postRepository.findById(postUuid)
				.map(post -> ResponseEntity.ok(commentRepository.findCommentByPost(post).stream().map(Comment::toDto).toList()))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@GetMapping("/api/v1/comment/all")
	public List<CommentDto> getAllComments() {
		return commentRepository.findAll().stream().map(Comment::toDto).toList();
	}
}
