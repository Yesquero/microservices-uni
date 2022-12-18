package com.example.secondbackend;

import com.example.secondbackend.dto.PostDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "post_uuid")
    private UUID uuid;
    private Long userId;
    private String title;
    private String body;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();

    public void addComment(Comment comment) {
        comment.setPost(this);
        comments.add(comment);
    }

    public void removeComment(Comment comment) {
        comment.setPost(null);
        comments.remove(comment);
    }

    public PostDto toDto() {
        return new PostDto(
                uuid, userId, title, body, comments.stream().map(Comment::getText).toList()
        );
    }
}
