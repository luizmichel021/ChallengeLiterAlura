package com.alura.literalura.dados;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record DadosAutor(@JsonProperty("name") String nome,
                         @JsonProperty("birth_year") Integer anoNascimento,
                         @JsonProperty("death_year") Integer anoFalecimento) {

    @Override
    public String toString() {
        return String.format("""
                Nome do Autor: %s
                Ano De Nascimento: %d
                Ano Falecimento: %d
                """,nome, anoNascimento, anoFalecimento);
    }
}