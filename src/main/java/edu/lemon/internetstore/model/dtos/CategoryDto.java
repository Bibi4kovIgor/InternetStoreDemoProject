package edu.lemon.internetstore.model.dtos;

import lombok.Builder;


@Builder
public record CategoryDto(String id, String name, String description){}
