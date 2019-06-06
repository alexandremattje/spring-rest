package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioAutenticado {

    private String login;

    private String nome;

    private String token;

    @Builder.Default
    private Boolean administrador = Boolean.FALSE;

    @Builder.Default
    private Boolean autenticado = Boolean.FALSE;

}
