package com.example.firstbackend;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (userRepository.findAll().isEmpty()) {
            String nameOne = "sample-user-one";
            Long idOne = 123L;
            String nameTwo = "sample-user-two";
            Long idTwo = 184L;

            UserDto userOne = new UserDto();
            userOne.setUserId(idOne);
            userOne.setName(nameOne);

            UserDto userTwo = new UserDto();
            userTwo.setUserId(idTwo);
            userTwo.setName(nameTwo);

            userRepository.saveAllAndFlush(List.of(userOne, userTwo));
        }
    }
}
