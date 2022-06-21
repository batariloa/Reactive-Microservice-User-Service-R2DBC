package com.batarilo.reactiveuserservice.controller;

import com.batarilo.reactiveuserservice.dto.TransactionRequestDto;
import com.batarilo.reactiveuserservice.dto.TransactionResponseDto;
import com.batarilo.reactiveuserservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("user/transaction")
public class UserTransactionController {


    @Autowired
    private TransactionService transactionService;


    @PostMapping
    public Mono<TransactionResponseDto> createTransaction(@RequestBody Mono<TransactionRequestDto> transactionRequestDtoMono){

        return transactionRequestDtoMono.flatMap(transactionService::createTransaction);
    }


}
