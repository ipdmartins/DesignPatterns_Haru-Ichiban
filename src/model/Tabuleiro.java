/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ipdmartins
 */
public class Tabuleiro {

    private String[][] tabuleiro;
    private String[][] redtabuleiro;
    private String[][] yellowtabuleiro;
    private String[][] pontos;
    private int darknenufarRow;
    private int darknenufarCol;
    private int redsapoROW;
    private int redsapoCOL;
    private int yellowsapoROW;
    private int yellowsapoCOL;

    public Tabuleiro() {
        tabuleiro = new String[5][5];
        redtabuleiro = new String[4][3];
        yellowtabuleiro = new String[4][3];
        pontos = new String[2][9];
    }

    public void setTabuleiro(String agua, String nenufar, String darknenufar, String redfrog, String yellowfrog,
            String redflower, String haru, String yellowflower, String mostrar) {
        //Montagem do tabuleiro central
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tabuleiro[i][j] = agua;
            }
        }
        tabuleiro[0][0] = nenufar;
        tabuleiro[0][2] = nenufar;
        tabuleiro[0][4] = nenufar;
        tabuleiro[1][1] = darknenufar;
        darknenufarRow = 1;
        darknenufarCol = 1;
        tabuleiro[1][2] = nenufar;
        tabuleiro[1][3] = nenufar;
        tabuleiro[2][0] = nenufar;
        tabuleiro[2][1] = redfrog;
        redsapoROW = 2;
        redsapoCOL = 1;
        tabuleiro[1][3] = yellowfrog;
        yellowsapoROW = 1;
        yellowsapoCOL = 3;
        tabuleiro[2][3] = nenufar;
        tabuleiro[2][4] = nenufar;
        tabuleiro[3][1] = nenufar;
        tabuleiro[3][2] = nenufar;
        tabuleiro[3][3] = nenufar;
        tabuleiro[4][0] = nenufar;
        tabuleiro[4][2] = nenufar;
        tabuleiro[4][4] = nenufar;

        //Montagem do tabuleiro flores vermelhas
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                redtabuleiro[i][j] = redflower;
            }
        }
        redtabuleiro[2][2] = mostrar;
        redtabuleiro[3][0] = haru;
        redtabuleiro[3][1] = haru;
        redtabuleiro[3][2] = haru;

        //Montagem do tabuleiro flores amarelas
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                yellowtabuleiro[i][j] = yellowflower;
            }
        }
        yellowtabuleiro[2][0] = mostrar;
        yellowtabuleiro[3][0] = haru;
        yellowtabuleiro[3][1] = haru;
        yellowtabuleiro[3][2] = haru;
        
    }
    
    public void setTabuleiroPontos(String um, String dois, String tres,
            String quatro, String cinco, String red, String yellow, String mato){
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 9; j++) {
                pontos[i][j] = mato;
            }
        }
        pontos[0][0] = red;
        pontos[0][1] = dois;
        pontos[0][3] = quatro;
        pontos[0][5] = quatro;
        pontos[0][7] = dois;
        pontos[0][8] = yellow;
        
        pontos[1][0] = um;
        pontos[1][2] = tres;
        pontos[1][4] = cinco;
        pontos[1][6] = tres;
        pontos[1][8] = um;
    }

    public String[][] getPontos() {
        return pontos;
    }

    public String[][] getTabuleiro() {
        return tabuleiro;
    }

    public String[][] getRedtabuleiro() {
        return redtabuleiro;
    }

    public String[][] getYellowtabuleiro() {
        return yellowtabuleiro;
    }

    public int getDarknenufarRow() {
        return darknenufarRow;
    }

    public int getDarknenufarCol() {
        return darknenufarCol;
    }

    public int getRedsapoROW() {
        return redsapoROW;
    }

    public int getRedsapoCOL() {
        return redsapoCOL;
    }

    public int getYellowsapoROW() {
        return yellowsapoROW;
    }

    public int getYellowsapoCOL() {
        return yellowsapoCOL;
    }

    public void setTabuleiro(String[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public void setRedtabuleiro(String[][] redtabuleiro) {
        this.redtabuleiro = redtabuleiro;
    }

    public void setYellowtabuleiro(String[][] yellowtabuleiro) {
        this.yellowtabuleiro = yellowtabuleiro;
    }

    
}
