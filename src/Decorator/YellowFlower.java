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
public class YellowFlower extends CelulaDecorator{

    public YellowFlower(Decorator decorator) {
        super(decorator);
    }
    
    @Override
    public String getCelulaAtual() {
        super.setCelulaAtual("imagens/nenufarFlowerYellow.png");
        return super.getCelulaAtual();
    }
   
}
