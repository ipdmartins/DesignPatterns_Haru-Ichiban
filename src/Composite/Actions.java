/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Composite;

/**
 *
 * @author ipdmartins
 */
public abstract class Actions {
    
    private int jogadas;

    public int getJogadas() {
        return jogadas;
    }
    
    public void setJogadas(int jogadas) {
        this.jogadas = jogadas;
    }
    
    public abstract int totalJogadas();
    
}
