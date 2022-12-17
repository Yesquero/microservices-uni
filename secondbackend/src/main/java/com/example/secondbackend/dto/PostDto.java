package com.example.secondbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class PostDto {
    private UUID uuid;
    private Long userId;
    private String title;
    private String body;
    private List<String> comments;
}
