package com.alura.literalura.repository;

import com.alura.literalura.dados.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    Autor findByNomeAutor(String nomeAutor);
}