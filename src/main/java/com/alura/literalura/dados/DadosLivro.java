package com.alura.literalura.dados;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public record DadosLivro(@JsonAlias("title") String titulo,
                         @JsonAlias("name") String nome,
                         @JsonAlias("brith_year") Integer anoNascimento,
                         @JsonAlias("death_year") Integer anoFalecimento,
                         @JsonAlias("lenguages") String idioma,
                         @JsonAlias("download_count") Integer numeroDeDownload) {
}
