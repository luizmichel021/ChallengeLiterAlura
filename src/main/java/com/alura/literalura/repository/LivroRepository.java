package com.alura.literalura.repository;

import com.alura.literalura.dados.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    List<Livro> findByIdioma(String idioma);

    List<Livro> findByAutorNomeAutor(String nomeAutor);
}