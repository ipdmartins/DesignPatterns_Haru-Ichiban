/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import abstractFactory.StringComum;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ipdmartins
 */
public class Pontuacao implements StringComum{
    
    private List<String> listaStrings;

    public Pontuacao() {
        this.listaStrings = new ArrayList<>();
        listaStrings.add("imagens/um.png");
        listaStrings.add("imagens/dois.png");
        listaStrings.add("imagens/tres.png");
        listaStrings.add("imagens/quatro.png");
        listaStrings.add("imagens/cinco.png");
        listaStrings.add("imagens/red.png");
        listaStrings.add("imagens/yellow.png");
        listaStrings.add("imagens/mato.png");
    }

    @Override
    public String receberString(int num) {
        return listaStrings.get(num);
    }
    
    
}
