package com.artigo.mapper.requests;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
public class GamePostRequestBody {

    @NotBlank
    private String name;

    @NotBlank
    private String categoria;
}
