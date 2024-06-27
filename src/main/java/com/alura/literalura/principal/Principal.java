package com.alura.literalura.principal;

import br.com.alura.screenmatch.service.ConverteDados;
import com.alura.literalura.dados.DadosLivro;
import com.alura.literalura.service.ApiService;

public class Principal {

    private ApiService consumo = new ApiService();
    private ConverteDados conversor = new ConverteDados();





    public void exibeMenu(){
        var json = consumo.obterDados();
        System.out.println(json);
        var dados = conversor.obterDados(json ,DadosLivro.class);
        System.out.println(dados);

    }
}
