package com.batarilo.reactiveuserservice.service;

import com.batarilo.reactiveuserservice.dto.UserDto;
import com.batarilo.reactiveuserservice.repository.UserRepository;
import com.batarilo.reactiveuserservice.util.EntityDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Flux<UserDto> getAllUsers() {
        return userRepository.findAll()
                .map(EntityDtoUtil::toDto);
    }

    public Mono<UserDto> getUserById(int id){

        return userRepository.findById(id)
                .map(EntityDtoUtil::toDto);
    }

    public Mono<UserDto> createUser(Mono<UserDto> userDto){

        return userDto.map(EntityDtoUtil::toEntity)
                .flatMap(userRepository::save)
                .map(EntityDtoUtil::toDto);

    }

    public Mono<UserDto> updateUser(int id, Mono<UserDto> userDtoMono){

        return userRepository.findById(id)
                .flatMap(u -> userDtoMono
                        .map(EntityDtoUtil::toEntity)
                        .doOnNext(e ->e.setId(id)))
                .flatMap(userRepository::save)
                .map(EntityDtoUtil::toDto);

    }

    public Mono<Void> deleteUser(int id){

        return userRepository.deleteById(id);
    }
}
