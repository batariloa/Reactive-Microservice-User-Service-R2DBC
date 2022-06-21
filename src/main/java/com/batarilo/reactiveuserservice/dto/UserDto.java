package com.batarilo.reactiveuserservice.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class UserDto {

    private Integer id;
    private String name;
    private Integer balance;


}
