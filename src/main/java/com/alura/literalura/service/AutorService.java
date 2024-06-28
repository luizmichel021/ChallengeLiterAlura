package com.alura.literalura.service;

import com.alura.literalura.dados.Autor;
import com.alura.literalura.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    @Autowired
    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Transactional
    public void salvar(Autor autor) {
        autorRepository.save(autor);
    }

    public Autor buscarPorNome(String nomeAutor) {
        return autorRepository.findByNomeAutor(nomeAutor);
    }

    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }
}