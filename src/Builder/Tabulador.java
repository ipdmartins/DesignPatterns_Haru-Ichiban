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
public class Tabulador extends Builder {

    private Tabuleiro tabuleiro;

    @Override
    public void reset() {
        tabuleiro = new Tabuleiro();
    }

    @Override
    public Tabuleiro getTabuleiros() {
        return tabuleiro;
    }

}
