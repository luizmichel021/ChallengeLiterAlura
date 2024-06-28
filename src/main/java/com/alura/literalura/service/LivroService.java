package com.alura.literalura.service;

import com.alura.literalura.dados.Livro;
import com.alura.literalura.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Transactional
    public void salvar(Livro livro) {
        livroRepository.save(livro);
    }

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    public List<Livro> listarPorIdioma(String idioma) {
        return livroRepository.findByIdioma(idioma);
    }

    public List<Livro> listarPorNomeAutor(String nomeAutor) {
        return livroRepository.findByAutorNomeAutor(nomeAutor);
    }
}