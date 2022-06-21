package com.batarilo.reactiveuserservice.util;

import com.batarilo.reactiveuserservice.dto.TransactionRequestDto;
import com.batarilo.reactiveuserservice.dto.TransactionResponseDto;
import com.batarilo.reactiveuserservice.dto.TransactionStatus;
import com.batarilo.reactiveuserservice.dto.UserDto;
import com.batarilo.reactiveuserservice.entity.User;
import com.batarilo.reactiveuserservice.entity.UserTransaction;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EntityDtoUtil {

    public static UserDto toDto(User user){

        return UserDto.builder()
                .balance(user.getBalance())
                .id(user.getId())
                .name(user.getName())
                .build();
    }

    public static User toEntity(UserDto userDto){

        return User.builder()
                .balance(userDto.getBalance())
                .id(userDto.getId())
                .name(userDto.getName())
                .build();
    }

    public static UserTransaction toEntity(TransactionRequestDto transactionRequestDto){

        return UserTransaction.builder()
                .userId(transactionRequestDto.getUserId())
                .amount(transactionRequestDto.getAmount())
                .transactionDate(LocalDateTime.now())
                .build();

    }

    public static TransactionResponseDto toDto(TransactionRequestDto requestDto, TransactionStatus status){

        return TransactionResponseDto.builder()
                .status(status)
                .amount(requestDto.getAmount())
                .userId(requestDto.getUserId())
                .build();
    }
}
