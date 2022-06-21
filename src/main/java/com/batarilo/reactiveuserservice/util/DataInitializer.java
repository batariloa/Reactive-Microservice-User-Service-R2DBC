package com.batarilo.reactiveuserservice.util;

import com.batarilo.reactiveuserservice.entity.User;
import com.batarilo.reactiveuserservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info("start data initialization...");
        this.userRepository
                .saveAll(
                        List.of(
                                User.builder().name("Dorian Garden").balance(40000).build(),
                                User.builder().name("Jeffree Michaels").balance(95000).build()
                        )
                )
                .thenMany(
                        this.userRepository.findAll()
                )
                .subscribe((data) -> log.info("post:" + data),
                        (err) -> log.error("error" + err),
                        () -> log.info("initialization is done...")
                );
    }


}