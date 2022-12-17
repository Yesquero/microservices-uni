package com.example.secondbackend;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {
    private final PostRepository postRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (!postRepository.findAll().isEmpty()) {
            return;
        }

        Long userOneId = 123L;
        Long userTwoId = 184L;

        Post firstPost = new Post();
        firstPost.setBody("Sample Text");
        firstPost.setTitle("First Post");
        firstPost.setUserId(userOneId);

        Post secondPost = new Post();
        secondPost.setBody("[deleted]");
        secondPost.setTitle("Second Post");
        secondPost.setUserId(userTwoId);

        Comment commentOne = new Comment();
        commentOne.setUserId(userTwoId);
        commentOne.setText("My first comment!");

        Comment commentTwo = new Comment();
        commentTwo.setUserId(userOneId);
        commentTwo.setText("Great first comment.");

        Comment commentThree = new Comment();
        commentThree.setUserId(userOneId);
        commentThree.setText("Nice post.");

        firstPost.addComment(commentOne);
        firstPost.addComment(commentTwo);
        secondPost.addComment(commentThree);

        postRepository.saveAllAndFlush(List.of(firstPost, secondPost));
    }
}
