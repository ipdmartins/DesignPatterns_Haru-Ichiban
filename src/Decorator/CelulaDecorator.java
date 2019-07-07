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
public abstract class CelulaDecorator implements Decorator {

    private Decorator decorator;
    
    public CelulaDecorator(Decorator decorator) {
        this.decorator = decorator;
    }

    @Override
    public String getCelulaAtual() {
        return this.decorator.getCelulaAtual();
    }

    @Override
    public void setCelulaAtual(String s) {
        this.decorator.setCelulaAtual(s);
    }
    
    
}
