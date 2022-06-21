package com.batarilo.reactiveuserservice.entity;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
@Builder
@Data
public class User {
    @Id
    private Integer id;
    private String name;
    private Integer balance;


}
