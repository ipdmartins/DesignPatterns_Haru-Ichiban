/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Composite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ipdmartins
 */
public class Jogadas extends Actions{
    
     private List<Actions> jogadores = new ArrayList<>();
     
     public void add(Actions participante) {
        jogadores.add(participante);
    }

    public void remove(Actions participante) {
        jogadores.remove(participante);
    }

    public Actions getParticipante(int index) {
        return jogadores.get(index);
    }

    @Override
    public int totalJogadas() {
        int total = 0;
        for (Actions a : jogadores) {
            total += a.getJogadas();
        }
        return total;
    }
    
}
