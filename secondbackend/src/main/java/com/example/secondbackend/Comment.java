package com.example.secondbackend;

import com.example.secondbackend.dto.CommentDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "comment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private Long userId;
	private String text;
	@ManyToOne
	private Post post;

	public CommentDto toDto() {
		return new CommentDto(
				id, userId, text, post.getUuid()
		);
	}
}
