package com.batarilo.reactiveuserservice.service;


import com.batarilo.reactiveuserservice.dto.TransactionRequestDto;
import com.batarilo.reactiveuserservice.dto.TransactionResponseDto;
import com.batarilo.reactiveuserservice.dto.TransactionStatus;
import com.batarilo.reactiveuserservice.repository.UserRepository;
import com.batarilo.reactiveuserservice.repository.UserTransactionRepository;
import com.batarilo.reactiveuserservice.util.EntityDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class TransactionService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTransactionRepository userTransactionRepository;

    public Mono<TransactionResponseDto> createTransaction(final TransactionRequestDto transactionRequestDto){

        return userRepository.updateUserBalance(transactionRequestDto.getUserId(), transactionRequestDto.getAmount())
                .filter(Boolean::booleanValue) //if successful balance change
                .map(b-> EntityDtoUtil.toEntity(transactionRequestDto))
                .flatMap(userTransactionRepository::save)
                .map(ut->EntityDtoUtil.toDto(transactionRequestDto, TransactionStatus.APPROVED))
                .defaultIfEmpty(EntityDtoUtil.toDto(transactionRequestDto,TransactionStatus.DECLINED));
    }

}
