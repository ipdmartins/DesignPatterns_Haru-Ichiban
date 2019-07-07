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
public interface ControleJogo {
    
    void inicializar();//criou o tabuleiro
    
    void pegarRedFlower();
    
    void pegarYellowFlower();
    
    void mostrarVermelha();
    
    void mostrarAmarela();
    
    int definirStatus();
    
    void posicionarVermelha();
    
    void posicionarAmarela();
    
    void marcarNenufar();
    
    void moverSapo();
    
    void ventoPrimaveraLEFT();
    
    void ventoPrimaveraDOWN();
    
    void ventoPrimaveraRIGHT();
    
    void ventoPrimaveraUP();
    
    void setarDarkNenufarR();
    
    void setarDarkNenufarY();
    
    void removerSapos();
            
    void addObservador(Observador obs);

    void removeObservador(Observador obs);

    void notificarMudancaTabuleiro();
    
    void fimDeJogo();
    
}
