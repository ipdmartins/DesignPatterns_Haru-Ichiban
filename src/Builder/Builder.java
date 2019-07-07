/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

import model.Tabuleiro;

/**
 *
 * @author ipdmartins
 */
public abstract class Builder {
    
    public abstract void reset();
    
    public abstract Tabuleiro getTabuleiros();
    
    public void construirTabuleiros(String agua, String nenufar, String darknenufar, String redfrog, String yellowfrog,
            String redflower, String haru, String yellowflower, String mostrar) {
        
        getTabuleiros().setTabuleiro(agua, nenufar, darknenufar, redfrog, yellowfrog, redflower, haru, yellowflower, mostrar);
    }
    
    public void construirTabuleiroPontos(String um, String dois, String tres,
            String quatro, String cinco, String red, String yellow, String mato) {
        
        getTabuleiros().setTabuleiroPontos(um, dois, tres, quatro, cinco, red, yellow, mato);
    }
    
}
