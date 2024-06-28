package com.alura.literalura.principal;

import com.alura.literalura.dados.Autor;
import com.alura.literalura.dados.DadosAutor;
import com.alura.literalura.dados.DadosLivro;
import com.alura.literalura.dados.Livro;
import com.alura.literalura.service.ApiService;
import com.alura.literalura.service.AutorService;
import com.alura.literalura.service.LivroService;
import com.alura.literalura.service.MapeamentoDados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Principal {

    private final ApiService apiService = new ApiService();
    private final MapeamentoDados mapeamentoDados = new MapeamentoDados();
    private final LivroService livroService;
    private final AutorService autorService;
    private final Scanner scanner;

    private static final String ENDERECO_API = "https://gutendex.com/books/?search=";

    @Autowired
    public Principal(LivroService livroService, AutorService autorService) {
        this.livroService = livroService;
        this.autorService = autorService;
        this.scanner = new Scanner(System.in);
    }

    public void exibeMenu() {
        int opcao = -1;
        while (opcao != 0) {
            String menu = """
                    1 - Buscar Livro pelo Título
                    2 - Listar Livros registrados
                    3 - Listar Autores registrados
                    4 - Listar Livros por Idioma
                    5 - Listar Livros de um Autor
                    0 - Sair
                    """;

            System.out.println(menu);
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    buscarLivroWeb();
                    break;
                case 2:
                    listarLivrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarLivrosPorIdioma();
                    break;
                case 5:
                    listarLivrosDeUmAutor();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }



    private void buscarLivroWeb() {
        System.out.println("Digite o Título do Livro cujo autor deseja buscar:");
        String tituloLivro = scanner.nextLine();
        String json = apiService.obterDados(ENDERECO_API + tituloLivro.replace(" ", "+").toLowerCase());
        mapeamentoDados.mapeador(json);
    }

    private void listarLivrosRegistrados() {
        List<Livro> livros = livroService.listarTodos();
        if (!livros.isEmpty()) {
            System.out.println("Livros registrados:");
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        } else {
            System.out.println("Nenhum livro registrado.");
        }
    }

    private void listarAutoresRegistrados() {
        List<Autor> autores = autorService.listarTodos();
        if (!autores.isEmpty()) {
            System.out.println("Autores registrados:");
            for (Autor autor : autores) {
                System.out.println(autor);
            }
        } else {
            System.out.println("Nenhum autor registrado.");
        }
    }

    private void listarLivrosPorIdioma() {
        System.out.println("Digite o idioma desejado:");
        String idioma = scanner.nextLine();
        List<Livro> livrosPorIdioma = livroService.listarPorIdioma(idioma);
        if (!livrosPorIdioma.isEmpty()) {
            System.out.printf("Livros em %s:\n", idioma);
            for (Livro livro : livrosPorIdioma) {
                System.out.println(livro);
            }
        } else {
            System.out.printf("Nenhum livro encontrado em %s.\n", idioma);
        }
    }

    private void listarLivrosDeUmAutor() {
        System.out.println("Digite o nome do autor:");
        String nomeAutor = scanner.nextLine();
        List<Livro> livrosDoAutor = livroService.listarPorNomeAutor(nomeAutor);
        if (!livrosDoAutor.isEmpty()) {
            System.out.printf("Livros do autor %s:\n", nomeAutor);
            for (Livro livro : livrosDoAutor) {
                System.out.println(livro);
            }
        } else {
            System.out.printf("Nenhum livro encontrado para o autor %s.\n", nomeAutor);
        }
    }


}
