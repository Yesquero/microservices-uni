package com.example.firstbackend;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user_entity")
public class UserDto {

    @Id
    private Long userId;
    private String name;

}
