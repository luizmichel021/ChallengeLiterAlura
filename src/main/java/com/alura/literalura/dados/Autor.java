package com.alura.literalura.dados;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String nomeAutor;

    private int dataNascimento;
    private int anoFalecimento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Livro> livros = new ArrayList<>();

    public Autor() {
    }

    public Autor(String nomeAutor, int dataNascimento, int anoFalecimento) {
        this.nomeAutor = nomeAutor;
        this.dataNascimento = dataNascimento;
        this.anoFalecimento = anoFalecimento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public int getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(int dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(int anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public void adicionarLivro(Livro livro) {
        this.livros.add(livro);
        livro.setAutor(this);
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nomeAutor='" + nomeAutor + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", anoFalecimento=" + anoFalecimento +
                '}';
    }
}