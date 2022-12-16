package com.example.secondbackend;

import lombok.Data;

import java.util.UUID;

@Data
public class PostDto {

	private UUID uuid;
	private Long userId;
	private String title;
	private String body;

}
