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
public class CalculaPontos implements Calculador {

	private int redPoints;
	private int yellowPoints;
	private boolean redFive;
	private boolean yellowFive;

	public CalculaPontos() {
		this.redPoints = 0;
		this.yellowPoints = 0;
		redFive = false;
		yellowFive = false;
	}

	@Override
	public void calculaTabuleiro(Board t) {

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				// CALCULA UM PONTO
				if (j < 4 && i < 4) {
					if (t.getTabuleiro()[i][j].equals(t.getNenufarredflower())
							&& t.getTabuleiro()[i + 1][j].equals(t.getNenufarredflower())
							&& t.getTabuleiro()[i + 1][j + 1].equals(t.getNenufarredflower())
							&& t.getTabuleiro()[i][j + 1].equals(t.getNenufarredflower())) {
						redPoints++;
					} else if (t.getTabuleiro()[i][j].equals(t.getNenufaryellowflower())
							&& t.getTabuleiro()[i][j + 1].equals(t.getNenufaryellowflower())
							&& t.getTabuleiro()[i + 1][j + 1].equals(t.getNenufaryellowflower())
							&& t.getTabuleiro()[i + 1][j].equals(t.getNenufaryellowflower())) {
						yellowPoints++;
					}
				}

				////////////////////////////////////////

				if (j < 2 && i < 2) {// DIAGONAL ESQUERDA P DIREITA TOPO
					// CINCO PONTOS
					if (j == 0 && i == 0) {
						if (t.getTabuleiro()[i][j].equals(t.getNenufarredflower())
								&& t.getTabuleiro()[i + 1][j + 1].equals(t.getNenufarredflower())
								&& t.getTabuleiro()[i + 3][j + 3].equals(t.getNenufarredflower())
								&& t.getTabuleiro()[i + 4][j + 4].equals(t.getNenufarredflower())
								&& t.getTabuleiro()[i + 2][j + 2].equals(t.getNenufarredflower())) {
							redPoints += 5;
							redFive = true;
						} else if (t.getTabuleiro()[i][j].equals(t.getNenufaryellowflower())
								&& t.getTabuleiro()[i + 1][j + 1].equals(t.getNenufarredflower())
								&& t.getTabuleiro()[i + 3][j + 3].equals(t.getNenufaryellowflower())
								&& t.getTabuleiro()[i + 4][j + 4].equals(t.getNenufarredflower())
								&& t.getTabuleiro()[i + 2][j + 2].equals(t.getNenufaryellowflower())) {
							yellowPoints += 5;
							yellowFive = true;
						}
					}
					// TRES PONTOS
					if (!redFive && t.getTabuleiro()[i][j].equals(t.getNenufarredflower())
							&& t.getTabuleiro()[i + 1][j + 1].equals(t.getNenufarredflower())
							&& t.getTabuleiro()[i + 3][j + 3].equals(t.getNenufarredflower())
							&& t.getTabuleiro()[i + 2][j + 2].equals(t.getNenufarredflower())) {
						redPoints += 3;
					} else if (!yellowFive && t.getTabuleiro()[i][j].equals(t.getNenufaryellowflower())
							&& t.getTabuleiro()[i + 1][j + 1].equals(t.getNenufaryellowflower())
							&& t.getTabuleiro()[i + 3][j + 3].equals(t.getNenufaryellowflower())
							&& t.getTabuleiro()[i + 2][j + 2].equals(t.getNenufaryellowflower())) {
						yellowPoints += 3;
					}
				}

				////////////////////////////////////////////////////////////////

				if (j > 2 && i < 2) {// DIAGONAL ESQUERDA P DIREITA RODAPE
					// CINCO PONTOS
					if (j == 4 && i == 0) {
						if (t.getTabuleiro()[i][j].equals(t.getNenufarredflower())
								&& t.getTabuleiro()[i + 1][j - 1].equals(t.getNenufarredflower())
								&& t.getTabuleiro()[i + 3][j - 3].equals(t.getNenufarredflower())
								&& t.getTabuleiro()[i + 4][j - 4].equals(t.getNenufarredflower())
								&& t.getTabuleiro()[i + 2][j - 2].equals(t.getNenufarredflower())) {
							redPoints += 5;
							redFive = true;
						} else if (t.getTabuleiro()[i][j].equals(t.getNenufaryellowflower())
								&& t.getTabuleiro()[i + 1][j - 1].equals(t.getNenufaryellowflower())
								&& t.getTabuleiro()[i + 3][j - 3].equals(t.getNenufaryellowflower())
								&& t.getTabuleiro()[i + 4][j - 4].equals(t.getNenufaryellowflower())
								&& t.getTabuleiro()[i + 2][j - 2].equals(t.getNenufaryellowflower())) {
							yellowPoints += 5;
							yellowFive = true;
						}
					} 
					// TRES PONTOS
					if (!redFive && t.getTabuleiro()[i][j].equals(t.getNenufarredflower())
							&& t.getTabuleiro()[i + 1][j - 1].equals(t.getNenufarredflower())
							&& t.getTabuleiro()[i + 3][j - 3].equals(t.getNenufarredflower())
							&& t.getTabuleiro()[i + 2][j - 2].equals(t.getNenufarredflower())) {
						redPoints += 3;
					}else if (!yellowFive && t.getTabuleiro()[i][j].equals(t.getNenufaryellowflower())
							&& t.getTabuleiro()[i + 1][j - 1].equals(t.getNenufaryellowflower())
							&& t.getTabuleiro()[i + 3][j - 3].equals(t.getNenufaryellowflower())
							&& t.getTabuleiro()[i + 2][j - 2].equals(t.getNenufaryellowflower())) {
						yellowPoints += 3;
					}
				}

				///////////////////////////////////////////////////////
				
				if (j < 2) {//HORIZONTAL ESQ P DIR
					// CINCO PONTOS
					if (j == 0) {// HORIZONTAL ESQ P DIR
						if (t.getTabuleiro()[i][j].equals(t.getNenufarredflower())
								&& t.getTabuleiro()[i][j + 1].equals(t.getNenufarredflower())
								&& t.getTabuleiro()[i][j + 2].equals(t.getNenufarredflower())
								&& t.getTabuleiro()[i][j + 3].equals(t.getNenufarredflower())
								&& t.getTabuleiro()[i][j + 4].equals(t.getNenufarredflower())) {
							redPoints += 5;
							redFive = true;
						} else if (t.getTabuleiro()[i][j].equals(t.getNenufaryellowflower())
								&& t.getTabuleiro()[i][j + 1].equals(t.getNenufaryellowflower())
								&& t.getTabuleiro()[i][j + 2].equals(t.getNenufaryellowflower())
								&& t.getTabuleiro()[i][j + 3].equals(t.getNenufaryellowflower())
								&& t.getTabuleiro()[i][j + 4].equals(t.getNenufaryellowflower())) {
							yellowPoints += 5;
							yellowFive = true;
						}
						// DOIS PONTOS
					} 
					if (!redFive && t.getTabuleiro()[i][j].equals(t.getNenufarredflower())
							&& t.getTabuleiro()[i][j + 1].equals(t.getNenufarredflower())
							&& t.getTabuleiro()[i][j + 3].equals(t.getNenufarredflower())
							&& t.getTabuleiro()[i][j + 2].equals(t.getNenufarredflower())) {
						redPoints += 2;
						System.err.println("redpoints: "+ redPoints);
					} else if (!yellowFive && t.getTabuleiro()[i][j].equals(t.getNenufaryellowflower())
							&& t.getTabuleiro()[i][j + 1].equals(t.getNenufaryellowflower())
							&& t.getTabuleiro()[i][j + 3].equals(t.getNenufaryellowflower())
							&& t.getTabuleiro()[i][j + 2].equals(t.getNenufaryellowflower())) {
						yellowPoints += 2;
					}
				}

				////////////////////////////////////////////
				
				if (i < 2) {// VERTICAL CIMA P BAIXO
					// CINCO PONTOS
					if (i == 0) {
						if (t.getTabuleiro()[i][j].equals(t.getNenufarredflower())
								&& t.getTabuleiro()[i + 1][j].equals(t.getNenufarredflower())
								&& t.getTabuleiro()[i + 2][j].equals(t.getNenufarredflower())
								&& t.getTabuleiro()[i + 3][j].equals(t.getNenufarredflower())
								&& t.getTabuleiro()[i + 4][j].equals(t.getNenufarredflower())) {
							redPoints += 5;
							redFive = true;
						} else if (t.getTabuleiro()[i][j].equals(t.getNenufaryellowflower())
								&& t.getTabuleiro()[i + 1][j].equals(t.getNenufaryellowflower())
								&& t.getTabuleiro()[i + 2][j].equals(t.getNenufaryellowflower())
								&& t.getTabuleiro()[i + 3][j].equals(t.getNenufaryellowflower())
								&& t.getTabuleiro()[i + 4][j].equals(t.getNenufaryellowflower())) {
							yellowPoints += 5;
							yellowFive = true;
						}
						// DOIS PONTOS
					} 
					if (!redFive &&  t.getTabuleiro()[i][j].equals(t.getNenufarredflower())
							&& t.getTabuleiro()[i + 1][j].equals(t.getNenufarredflower())
							&& t.getTabuleiro()[i + 3][j].equals(t.getNenufarredflower())
							&& t.getTabuleiro()[i + 2][j].equals(t.getNenufarredflower())) {
						redPoints += 2;
					} else if (!yellowFive &&  t.getTabuleiro()[i][j].equals(t.getNenufaryellowflower())
							&& t.getTabuleiro()[i + 1][j].equals(t.getNenufaryellowflower())
							&& t.getTabuleiro()[i + 3][j].equals(t.getNenufaryellowflower())
							&& t.getTabuleiro()[i + 2][j].equals(t.getNenufaryellowflower())) {
						yellowPoints += 2;
					}
				}
			}
		}
	}

	public int getRedPoints() {
		return redPoints;
	}

	public int getYellowPoints() {
		return yellowPoints;
	}

}
