package com.example.firstbackend;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (userRepository.findAll().isEmpty()) {
            String name = "default-user";
            Long defaultUserId = 123L;

            UserDto sampleUser = new UserDto();
            sampleUser.setUserId(defaultUserId);

            sampleUser.setName(name);

            userRepository.saveAndFlush(sampleUser);
        }
    }
}
