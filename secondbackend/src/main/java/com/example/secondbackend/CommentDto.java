package com.example.secondbackend;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.core.ReactiveAdapterRegistry;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CommentDto {

	private UUID id;
	private String text;

}
