package com.batarilo.reactiveuserservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionRequestDto  {
    private Integer userId;
    private Integer amount;

}
