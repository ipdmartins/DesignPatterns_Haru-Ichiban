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
public class CelulaAgua implements Decorator{
    
    private String stringer;

    public CelulaAgua() {
        this.stringer = "imagens/agua.png";
    }

    @Override
    public String getCelulaAtual() {
        return stringer;
    }

    @Override
    public void setCelulaAtual(String s) {
        stringer = s;
    }
        
}
