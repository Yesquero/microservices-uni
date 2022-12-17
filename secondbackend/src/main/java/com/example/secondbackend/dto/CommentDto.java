package com.example.secondbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CommentDto {
    private UUID uuid;
    private Long userId;
    private String text;
    private UUID postUuid;
}
