package com.example.firstbackend;

import lombok.Data;

import java.util.UUID;

@Data
public class ResponseDto {

	private UUID uuid;
	private String value;

}
