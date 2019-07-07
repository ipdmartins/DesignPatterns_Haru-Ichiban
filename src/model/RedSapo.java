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
public class RedSapo {
    
    private int row;
    private int col;
    private boolean pulou;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
    
    public boolean isPulou() {
		return pulou;
	}

	public void setPulou(boolean pulou) {
		this.pulou = pulou;
	}

	public String getRedGhostFrog() {
    	return "imagens/redGhostFrog.png";
    }
    
}
