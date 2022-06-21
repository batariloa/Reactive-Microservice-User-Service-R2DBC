package com.batarilo.reactiveuserservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionResponseDto {

    private Integer userId;
    private Integer amount;
    private TransactionStatus status;

}

