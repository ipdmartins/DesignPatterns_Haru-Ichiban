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
public class Jardineiro extends Actions {

    private boolean junior;

    public Jardineiro(boolean junior) {
        this.junior = junior;
        totalJogadas();
    }
    
    public void setJogadas(int n){
        super.setJogadas(n);
    }

    @Override
    public int totalJogadas() {
        if (junior) {
            super.setJogadas(2);
            return super.getJogadas();
        }
        super.setJogadas(4);
        return super.getJogadas();
    }

}
