/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor;

import model.*;

/**
 *
 * @author ipdmartins
 */
public class Placar implements Visitor {

    private int redpontos;
    private int yellowpontos;
    private int redMark;
    private int yellowMark;

    public Placar() {
        this.redpontos = 0;
        this.yellowpontos = 0;
        this.redMark = 0;
        this.yellowMark = 0;
    }

    @Override
    public void visitRedPlayer(RedPlayer redPlayer) {
        redMark = redPlayer.getPontos();
    }

    @Override
    public void visitYellowPlayer(YellowPlayer yellowPlayer) {
        yellowMark = yellowPlayer.getPontos();
    }

    public int getRedpontos() {
        return redpontos;
    }

    public int getYellowpontos() {
        return yellowpontos;
    }

    public int getRedMark() {
        return redMark;
    }

    public int getYellowMark() {
        return yellowMark;
    }

    public void setRedpontos() {
        this.redpontos = redMark;
    }

    public void setYellowpontos() {
        this.yellowpontos = yellowMark;
    }

}
