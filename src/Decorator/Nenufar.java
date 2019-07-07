/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorator;

/**
 *
 * @author ipdmartins
 */
public class Nenufar extends CelulaDecorator{

    public Nenufar(Decorator decorator) {
        super(decorator);
    }
    
    @Override
    public String getCelulaAtual() {
        super.setCelulaAtual("imagens/nenufar.png");
        return super.getCelulaAtual();
    }
   
}
