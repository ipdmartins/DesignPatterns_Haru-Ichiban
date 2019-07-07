/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

/**
 *
 * @author ipdmartins
 */
public class Board {

    private String [][] tabuleiro;
    private String nenufarredflower;
    private String nenufaryellowflower;

    public Board(String[][] tabuleiro, String nenufarredflower, String nenufaryellowflower) {
        this.tabuleiro = tabuleiro;
        this.nenufarredflower = nenufarredflower;
        this.nenufaryellowflower = nenufaryellowflower;
    }

    public String[][] getTabuleiro() {
        return tabuleiro;
    }

    public String getNenufarredflower() {
        return nenufarredflower;
    }

    public String getNenufaryellowflower() {
        return nenufaryellowflower;
    }
    
}
