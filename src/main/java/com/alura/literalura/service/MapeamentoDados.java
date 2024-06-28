package com.alura.literalura.service;

import br.com.alura.screenmatch.service.ConverteDados;
import com.alura.literalura.dados.Autor;
import com.alura.literalura.dados.DadosAutor;
import com.alura.literalura.dados.DadosLivro;
import com.alura.literalura.dados.Livro;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MapeamentoDados {
    ConverteDados conversor = new ConverteDados();
    public void mapeador (String json) {
        try {
            var objetoJson = conversor.obterDados(json, Object.class);
            List<Map<String, Object>> results = (List<Map<String, Object>>) ((Map<String, Object>) objetoJson).get("results");

            if (!results.isEmpty()) {
                Map<String, Object> primeiroResultado = results.get(0);

                // Extrai informações do autor, se disponível
                List<Map<String, Object>> autores = (List<Map<String, Object>>) primeiroResultado.get("authors");
                if (!autores.isEmpty()) {
                    Map<String, Object> autorJson = autores.get(0);
                    String nome = (String) autorJson.get("name");
                    int anoNascimento = (int) autorJson.get("birth_year");
                    int anoFalecimento = (int) autorJson.get("death_year");

                    DadosAutor autor = new DadosAutor(nome, anoNascimento, anoFalecimento);
                    System.out.println(autor);
                } else {
                    System.out.println("Nenhum autor encontrado.");
                }

                // Extrai informações do livro
                String titulo = (String) primeiroResultado.get("title");
                List<String> idiomas = (List<String>) primeiroResultado.get("languages");
                if (!idiomas.isEmpty()) {
                    String idioma = idiomas.get(0);
                    DadosLivro livro = new DadosLivro(titulo, idioma);
                    System.out.println(livro);
                } else {
                    System.out.println("Nenhum livro encontrado");
                }
            } else {
                System.out.println("Nenhum resultado encontrado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
