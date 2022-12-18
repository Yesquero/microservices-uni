package com.example.firstbackend;

import com.example.firstbackend.dto.UserBasicDto;
import com.example.firstbackend.dto.UserFullDto;
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

    private String address;

    public UserBasicDto toBasicDto() {
        return new UserBasicDto(userId, name);
    }

    public UserFullDto toDto() {
        return new UserFullDto(userId, name, address);
    }

}
