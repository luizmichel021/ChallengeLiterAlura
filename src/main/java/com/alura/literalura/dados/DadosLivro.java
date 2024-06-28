package com.alura.literalura.dados;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro(@JsonAlias("title")String titulo,@JsonAlias("languages")String idioma) {
    @Override
    public String toString() {
        return String.format("""
                Titulo: %s               
                Idioma: %s
                """,titulo,idioma);
    }
}
