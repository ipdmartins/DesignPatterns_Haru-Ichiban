/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author ipdmartins
 */
public interface Observador {

    void mudouTabuleiro();
    
    void fimJogo();
    
    void proximaEtapa();
    
    void habilitar(String s);
    
    void novaRodada();
    
}
