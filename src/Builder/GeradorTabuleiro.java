/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

/**
 *
 * @author ipdmartins
 */
public class GeradorTabuleiro {
    
    private Builder builder;

    public GeradorTabuleiro(Builder builder) {
        this.builder = builder;
    }
    
    public void construirTabuleiros(String agua, String nenufar, String darknenufar, String redfrog, String yellowfrog,
            String redflower, String haru, String yellowflower, String mostrar){
        
        builder.reset();
        builder.construirTabuleiros(agua, nenufar, darknenufar, redfrog, yellowfrog, redflower, haru, yellowflower, mostrar);
    }
    
    public void construirTabuleiroPontos(String um, String dois, String tres,
            String quatro, String cinco, String red, String yellow, String mato){
        
        builder.reset();
        builder.construirTabuleiroPontos(um, dois, tres, quatro, cinco, red, yellow, mato);
    }
    
}
