/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;
/**
 *
 * @author ipdmartins
 */
public abstract class JogoEstado {
    
    protected Jogo jogo;

    public JogoEstado(Jogo game) {
        this.jogo = game;
    }
    
    public abstract void proxEtapa();
    
}
