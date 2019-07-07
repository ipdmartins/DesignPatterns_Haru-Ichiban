package control;

import Builder.*;
import Composite.*;
import Decorator.*;
import Strategy.*;
import abstractFactory.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.*;
import visitor.*;

//OBSERVADO
public class Controller implements ControleJogo {

	private String[][] tabuleiro;
	private String[][] redtabuleiro;
	private String[][] yellowtabuleiro;
	private String[][] pontosTabuleiro;
	private List<Integer> yflist;
	private List<Integer> rflist;
	private Random random;
	private int rowTabuleiro;
	private int colTabuleiro;
	private int rowRedTab;
	private int colRedtab;
	private int rowYellowTab;
	private int colYellowTab;
	private int redn;
	private int yellown;
	private int darknenufarRow;
	private int darknenufarCol;
	private int nenufarROW;
	private int nenufarCOL;
	private int sorteadorR;
	private int sorteadorY;
	private int ventoTemp;
	private int lastTabROW;
	private int lastTabCOL;
	private int lastRedROW;
	private int lastRedCOL;
	private int lastYelROW;
	private int lastYelCOL;
	private int lastRedSapoRow;
	private int lastRedSapoCol;
	private int lastYellowSapoRow;
	private int lastYellowSapoCol;
	private int[] rharuNum;
	private int[] yharuNum;
	private boolean conddefinirYellow;
	private boolean conddefinirRed;
	private boolean condmostrarvermelha;
	private boolean condmostraramarela;
	private boolean redSapoBoolean;
	private boolean yellowSapoBoolean;
	private boolean redFlowerOver;
	private boolean yellowFlowerOver;
	private boolean empate;
	private boolean redLastPlay;
	private boolean yellowLastPlay;
	private boolean fimRodada;

	private static String agua;
	private static String darknenufar;
	private static String nenufar;
	private static String redflower;
	private static String redfrog;
	private static String redgardner;
	private static String yellowflower;
	private static String yellowfrog;
	private static String yellowgardner;
	private static String haru;
	private static String nenufarredflower;
	private static String nenufaryellowflower;
	private static String trilha;
	private static String mostrar;
	private static String um;
	private static String dois;
	private static String tres;
	private static String quatro;
	private static String cinco;
	private static String red;
	private static String yellow;
	private static String mato;
	private String temporaria;

	// ABSTRACT FACTORY
	private FabricaDeStrings fabrica;
	private StringAdresser endString;

	// MODEL
	private Pontuacao trilhaPontos;
	private RedPlayer redPlayer;
	private YellowPlayer yellowPlayer;
	private RedSapo redSapo;
	private YellowSapo yellowSapo;

	// VISITOR
	private Jogadores jogadores;
	private Placar placar;

	// BUILDER
	private Builder builder;
	private GeradorTabuleiro gerador;

	// DECORATOR
	private Decorator aguaDecor;
	private Decorator nenufarDecor;
	private Decorator darkNenufarDecor;
	private Decorator redFlowerDecor;
	private Decorator yellowFlowerDecor;
	private Decorator redFrogDecor;
	private Decorator yellowFrogDecor;

	// COMPOSITE
	private Jardineiro junior;
	private Jardineiro senior;
	private Jogadas jogadas;

	// STRATEGY
	private Pontuador pontuador;
	private Board board;
	private CalculaPontos calculaPontos;

	private List<Observador> observadores;

	private static Controller instance;

	public synchronized static Controller getInstance() {
		if (instance == null) {
			instance = new Controller();
		}
		return instance;
	}

	private Controller() {

		// DECORATOR
		aguaDecor = new CelulaAgua();
		agua = aguaDecor.getCelulaAtual();
		nenufarDecor = new Nenufar(aguaDecor);
		nenufar = nenufarDecor.getCelulaAtual();
		darkNenufarDecor = new DarkNenufar(aguaDecor);
		darknenufar = darkNenufarDecor.getCelulaAtual();
		redFrogDecor = new RedFrog(aguaDecor);
		redfrog = redFrogDecor.getCelulaAtual();
		yellowFrogDecor = new YellowFrog(aguaDecor);
		yellowfrog = yellowFrogDecor.getCelulaAtual();
		redFlowerDecor = new RedFlower(aguaDecor);
		nenufarredflower = redFlowerDecor.getCelulaAtual();
		yellowFlowerDecor = new YellowFlower(aguaDecor);
		nenufaryellowflower = yellowFlowerDecor.getCelulaAtual();

		observadores = new ArrayList<>();

		// ABSTRACT FACTORY
		fabrica = new FabricaModelo();
		endString = fabrica.buscarStringAdresser();
		redPlayer = fabrica.buscarRedPlayer();
		yellowPlayer = fabrica.buscarYellowPlayer();
		trilhaPontos = fabrica.buscarTrilhaPontuacao();

		// VISITOR
		jogadores = new Jogadores();
		jogadores.addIPlayer(redPlayer);
		jogadores.addIPlayer(yellowPlayer);
		placar = new Placar();
		jogadores.accept(placar);

		// MODEL
		redSapo = new RedSapo();
		yellowSapo = new YellowSapo();

		// ABSTRACT FACTORY
		haru = endString.receberString(0);
		trilha = endString.receberString(1);
		redflower = endString.receberString(2);
		yellowflower = endString.receberString(3);
		redgardner = endString.receberString(4);
		yellowgardner = endString.receberString(5);
		mostrar = endString.receberString(6);
		um = trilhaPontos.receberString(0);
		dois = trilhaPontos.receberString(1);
		tres = trilhaPontos.receberString(2);
		quatro = trilhaPontos.receberString(3);
		cinco = trilhaPontos.receberString(4);
		red = trilhaPontos.receberString(5);
		yellow = trilhaPontos.receberString(6);
		mato = trilhaPontos.receberString(7);

		// BUILDER
		random = new Random();
		builder = new Tabulador();
		gerador = new GeradorTabuleiro(builder);
		gerador.construirTabuleiros(agua, nenufar, darknenufar, redfrog, yellowfrog, redflower, haru, yellowflower,
				mostrar);
		gerador.construirTabuleiroPontos(um, dois, tres, quatro, cinco, red, yellow, mato);

		tabuleiro = new String[5][5];
		redtabuleiro = new String[4][3];
		yellowtabuleiro = new String[4][3];
		pontosTabuleiro = new String[2][9];
		tabuleiro = builder.getTabuleiros().getTabuleiro();
		redtabuleiro = builder.getTabuleiros().getRedtabuleiro();
		yellowtabuleiro = builder.getTabuleiros().getYellowtabuleiro();
		pontosTabuleiro = builder.getTabuleiros().getPontos();

		darknenufarRow = builder.getTabuleiros().getDarknenufarRow();
		darknenufarCol = builder.getTabuleiros().getDarknenufarCol();
		yellowSapo.setRow(builder.getTabuleiros().getYellowsapoROW());
		yellowSapo.setCol(builder.getTabuleiros().getYellowsapoCOL());
		redSapo.setRow(builder.getTabuleiros().getRedsapoROW());
		redSapo.setCol(builder.getTabuleiros().getRedsapoCOL());

		rharuNum = new int[3];
		yharuNum = new int[3];
		redn = 7;
		yellown = 7;
		empate = false;
		fimRodada = false;
	}

	public void SetarTabuleiros() {
		builder = new Tabulador();
		gerador = new GeradorTabuleiro(builder);
		gerador.construirTabuleiros(agua, nenufar, darknenufar, redfrog, yellowfrog, redflower, haru, yellowflower,
				mostrar);
		novaRodada();
	}

	public void novaRodada() {
		if (!fimRodada) {
			tabuleiro = builder.getTabuleiros().getTabuleiro();
			redtabuleiro = builder.getTabuleiros().getRedtabuleiro();
			yellowtabuleiro = builder.getTabuleiros().getYellowtabuleiro();

			darknenufarRow = builder.getTabuleiros().getDarknenufarRow();
			darknenufarCol = builder.getTabuleiros().getDarknenufarCol();
			yellowSapo.setRow(builder.getTabuleiros().getYellowsapoROW());
			yellowSapo.setCol(builder.getTabuleiros().getYellowsapoCOL());
			redSapo.setRow(builder.getTabuleiros().getRedsapoROW());
			redSapo.setCol(builder.getTabuleiros().getRedsapoCOL());
		} else if (fimRodada) {
			redtabuleiro = builder.getTabuleiros().getRedtabuleiro();
			yellowtabuleiro = builder.getTabuleiros().getYellowtabuleiro();
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (tabuleiro[i][j].equals(nenufarredflower) || tabuleiro[i][j].equals(nenufaryellowflower)) {
						tabuleiro[i][j] = nenufar;
					}
				}
			}
			tabuleiro[lastRedSapoRow][lastRedSapoCol] = redfrog;
			tabuleiro[lastYellowSapoRow][lastYellowSapoCol] = yellowfrog;
			tabuleiro[darknenufarRow][darknenufarCol] = darknenufar;
		}

		yellowLastPlay = false;
		redLastPlay = false;
		fimRodada = false;
		yellowFlowerOver = false;
		redFlowerOver = false;
		definirFloresNumeros();
	}

	public void definirFloresNumeros() {
		yflist = new ArrayList<>();
		rflist = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			yflist.add(i + 1);
			rflist.add(i + 1);
		}
	}

	public void pegarIndexTabuleiro(int selectedRow, int selectedColumn) {
		rowTabuleiro = selectedRow;
		colTabuleiro = selectedColumn;
	}

	public void pegarIndexRed(int selectedRow, int selectedColumn) {
		rowRedTab = selectedRow;
		colRedtab = selectedColumn;
	}

	public void pegarIndexYellow(int selectedRow, int selectedColumn) {
		rowYellowTab = selectedRow;
		colYellowTab = selectedColumn;
	}

	public boolean definirRedNum() {
		conddefinirRed = false;
		sorteadorR = -1;
		if (rflist.size() > 0) {// lista tem 7 numeros de 0 a 7
			while (conddefinirRed == false) {
				sorteadorR = random.nextInt(9);// randomico de 0 a 7
				for (int i = 0; i < rflist.size(); i++) {
					if (rflist.get(i) == sorteadorR) {// se achar o numero sorteado na lista
						redn = rflist.get(i);
						sorteadorR = i;
						conddefinirRed = true;
						break;
					}
				}
			}
		}
		return conddefinirRed;
	}

	public void pegarRedFlower() {
		if (!(rowRedTab == -1)) {
			if ((definirRedNum() == true && redtabuleiro[rowRedTab][colRedtab].equals(redflower))
					&& (tabuleiro[darknenufarRow][darknenufarCol].equals(darknenufar)
							&& redtabuleiro[2][2].equals(mostrar))) {
				if (redtabuleiro[3][0].equals(haru)) {
					redtabuleiro[3][0] = redPlayer.receberString(redn - 1);
					redtabuleiro[rowRedTab][colRedtab] = haru;
					rflist.remove(sorteadorR);
					rharuNum[0] = redn;
				} else if (redtabuleiro[3][1].equals(haru)) {
					redtabuleiro[3][1] = redPlayer.receberString(redn - 1);
					redtabuleiro[rowRedTab][colRedtab] = haru;
					rflist.remove(sorteadorR);
					rharuNum[1] = redn;
				} else if (redtabuleiro[3][2].equals(haru)) {
					redtabuleiro[3][2] = redPlayer.receberString(redn - 1);
					redtabuleiro[rowRedTab][colRedtab] = haru;
					rflist.remove(sorteadorR);
					rharuNum[2] = redn;
				} else {
					conddefinirRed = false;
				}
				boolean b = false;
				for (int i = 0; i < 3; i++) {
					if (redtabuleiro[3][i].equals(haru)) {
						b = true;
					}
				}
				if (!b) {
					redPlayer.setPegouFlor(true);
					if (rflist.size() == 0) {
						redFlowerOver = true;
					}
				}
				if (redPlayer.isPegouFlor() && yellowPlayer.isPegouFlor()) {
					proximaEtapa();
				}
			}
		}
	}

	public void pegarYellowFlower() {
		if (!(rowYellowTab == -1)) {
			if ((definirYellowNum() == true && yellowtabuleiro[rowYellowTab][colYellowTab].equals(yellowflower))
					&& (tabuleiro[darknenufarRow][darknenufarCol].equals(darknenufar)
							&& yellowtabuleiro[2][0].equals(mostrar))) {

				if (yellowtabuleiro[3][0].equals(haru)) {
					yellowtabuleiro[3][0] = yellowPlayer.receberString(yellown - 1);
					yellowtabuleiro[rowYellowTab][colYellowTab] = haru;
					yflist.remove(sorteadorY);
					yharuNum[0] = yellown;
				} else if (yellowtabuleiro[3][1].equals(haru)) {
					yellowtabuleiro[3][1] = yellowPlayer.receberString(yellown - 1);
					yellowtabuleiro[rowYellowTab][colYellowTab] = haru;
					yflist.remove(sorteadorY);
					yharuNum[1] = yellown;
				} else if (yellowtabuleiro[3][2].equals(haru)) {
					yellowtabuleiro[3][2] = yellowPlayer.receberString(yellown - 1);
					yellowtabuleiro[rowYellowTab][colYellowTab] = haru;
					yflist.remove(sorteadorY);
					yharuNum[2] = yellown;
				} else {
					conddefinirYellow = false;
				}
				boolean b = false;
				for (int i = 0; i < 3; i++) {
					if (yellowtabuleiro[3][i].equals(haru)) {
						b = true;
					}
				}
				if (!b) {
					yellowPlayer.setPegouFlor(true);
					if (yflist.size() == 0) {
						yellowFlowerOver = true;
					}
				}
				if (redPlayer.isPegouFlor() && yellowPlayer.isPegouFlor()) {
					proximaEtapa();
				}
			}
		}
	}

	public boolean definirYellowNum() {
		conddefinirYellow = false;
		sorteadorY = -1;
		if (yflist.size() > 0) {// lista tem 8 numeros de 0 a 8
			while (conddefinirYellow == false) {
				sorteadorY = random.nextInt(9);// randomico de 0 a 8
				for (int i = 0; i < yflist.size(); i++) {
					if (yflist.get(i) == sorteadorY) {// se achar o numero sorteado na lista
						yellown = yflist.get(i);
						sorteadorY = i;
						conddefinirYellow = true;
						break;
					}
				}
			}
		}
		return conddefinirYellow;
	}

	public void mostrarVermelha() {
		if (redtabuleiro[2][2].equals(mostrar) && !redtabuleiro[3][colRedtab].equals(haru)) {
			condmostrarvermelha = true;
			if (rflist.size() > 0) {
				for (int i = 0; i < 3; i++) {
					if (redtabuleiro[3][i].equals(haru)) {
						condmostrarvermelha = false;
						break;
					}
				}
			} else {
				int cont = 0;
				for (int i = 0; i < 3; i++) {
					if (redtabuleiro[3][i].equals(haru)) {
						cont++;
					}
				}
				if (cont == 1) {
					redLastPlay = true;
				}
			}
			if (condmostrarvermelha) {
				temporaria = redtabuleiro[3][colRedtab].toString();
				redtabuleiro[2][2] = redtabuleiro[3][colRedtab].toString();
				redtabuleiro[3][colRedtab] = haru;
				condmostrarvermelha = false;
				lastRedROW = 3;
				lastRedCOL = colRedtab;
				redPlayer.setMostrouFlor(true);
				if (redPlayer.isMostrouFlor() && yellowPlayer.isMostrouFlor()) {
					proximaEtapa();
				}
			}
		}
	}

	public void desfazerMostrarR() {
		redtabuleiro[3][lastRedCOL] = redtabuleiro[2][2];
		redtabuleiro[2][2] = mostrar;
	}

	public void refazerMostrarR() {
		redtabuleiro[2][2] = redtabuleiro[3][lastRedCOL];
		redtabuleiro[3][lastRedCOL] = haru;
	}

	public void mostrarAmarela() {
		if (yellowtabuleiro[2][0].equals(mostrar) && !yellowtabuleiro[3][colYellowTab].equals(haru)) {
			condmostraramarela = true;
			if (yflist.size() > 0) {
				for (int i = 0; i < 3; i++) {
					if (yellowtabuleiro[3][i].equals(haru)) {
						condmostraramarela = false;
						break;
					}
				}
			} else {
				int cont = 0;
				for (int i = 0; i < 3; i++) {
					if (yellowtabuleiro[3][i].equals(haru)) {
						cont++;
					}
				}
				if (cont == 1) {
					yellowLastPlay = true;
				}
			}
			if (condmostraramarela) {
				temporaria = yellowtabuleiro[3][colYellowTab].toString();
				yellowtabuleiro[2][0] = yellowtabuleiro[3][colYellowTab].toString();
				yellowtabuleiro[3][colYellowTab] = haru;
				condmostraramarela = false;
				lastYelCOL = colYellowTab;
				lastYelROW = 3;
				yellowPlayer.setMostrouFlor(true);
				if (redPlayer.isMostrouFlor() && yellowPlayer.isMostrouFlor()) {
					proximaEtapa();
				}
			}
		}
	}

	public void desfazerMostrarY() {
		yellowtabuleiro[3][lastYelCOL] = yellowtabuleiro[2][0];
		yellowtabuleiro[2][0] = mostrar;
	}

	public void refazerMostrarY() {
		yellowtabuleiro[2][0] = yellowtabuleiro[3][lastYelCOL];
		yellowtabuleiro[3][lastYelCOL] = haru;
	}

	public int definirStatus() {
		int compr = -1;
		int compy = -1;
		if (lastRedROW == 3 && lastYelROW == 3) {
			if (lastRedCOL == 0) {
				compr = rharuNum[0];
			} else if (lastRedCOL == 1) {
				compr = rharuNum[1];
			} else if (lastRedCOL == 2) {
				compr = rharuNum[2];
			}
			if (lastYelCOL == 0) {
				compy = yharuNum[0];
			} else if (lastYelCOL == 1) {
				compy = yharuNum[1];
			} else if (lastYelCOL == 2) {
				compy = yharuNum[2];
			}
			redPlayer.setDefiniuSatus(true);
			yellowPlayer.setDefiniuSatus(true);

			if (compr > compy) {
				// COMPOSITE
				numeroJogadas();
				redPlayer.setStatus(2);
				yellowPlayer.setStatus(1);
				proximaEtapa();
				return 2;
			} else if (compr < compy) {
				// COMPOSITE
				numeroJogadas();
				redPlayer.setStatus(1);
				yellowPlayer.setStatus(2);
				proximaEtapa();
				return 1;
			}
		}
		return 0;
	}

	public void numeroJogadas() {
		// COMPOSITE
		junior = new Jardineiro(true);
		senior = new Jardineiro(false);
		jogadas = new Jogadas();
		jogadas.add(junior);
		jogadas.add(senior);
	}

	public void empate(int n) {
		if (n == 1) {
			redPlayer.setStatus(2);
			yellowPlayer.setStatus(1);
		} else if (n == 2) {
			redPlayer.setStatus(1);
			yellowPlayer.setStatus(2);
		}
		empate = true;
		numeroJogadas();
		proximaEtapa();
	}

	public void movimentoEmpate() {
		if (redSapo.isPulou() && yellowSapo.isPulou()) {
			tabuleiro[lastRedSapoRow][lastRedSapoCol] = nenufarredflower;
			redtabuleiro[2][2] = mostrar;
			tabuleiro[lastYellowSapoRow][lastYellowSapoCol] = nenufaryellowflower;
			yellowtabuleiro[2][0] = mostrar;
			if ((tabuleiro[darknenufarRow][darknenufarCol].equals(darknenufar))) {
				tabuleiro[darknenufarRow][darknenufarCol] = nenufar;
			}
			jogadas.getParticipante(0).setJogadas(1);
			jogadas.getParticipante(1).setJogadas(2);
			empate = false;
			redSapo.setPulou(false);
			yellowSapo.setPulou(false);
			proximaEtapa();
		}
	}

	// COMPOSITE
	public void moverPecaR() {
		if (redPlayer.getStatus() == 2) {
			if (empate) {
				jogadas.getParticipante(1).setJogadas(2);
			} else {
				if (jogadas.getParticipante(1).getJogadas() == 4) {
					jogadas.getParticipante(1).setJogadas(3);
				} else if (jogadas.getParticipante(1).getJogadas() == 2) {
					jogadas.getParticipante(1).setJogadas(1);
				}
			}
			moverSapo();
		}
	}

	public void moverPecaY() {
		if (yellowPlayer.getStatus() == 2) {
			if (empate) {
				jogadas.getParticipante(1).setJogadas(2);
			} else {
				if (jogadas.getParticipante(1).getJogadas() == 4) {
					jogadas.getParticipante(1).setJogadas(3);
				} else if (jogadas.getParticipante(1).getJogadas() == 2) {
					jogadas.getParticipante(1).setJogadas(1);
				}
			}
			moverSapo();
		}
	}

	public void marcarNenufar() {
		nenufarROW = rowTabuleiro;
		nenufarCOL = colTabuleiro;
	}

	public void moverSapo() {
		if (tabuleiro[nenufarROW][nenufarCOL].equals(nenufar)) {
			if (tabuleiro[rowTabuleiro][colTabuleiro].equals(redfrog)) {
				verificaGhostFrog(1, 0);
				lastRedSapoRow = rowTabuleiro;
				lastRedSapoCol = colTabuleiro;
				tabuleiro[lastRedSapoRow][lastRedSapoCol] = redSapo.getRedGhostFrog();
				tabuleiro[nenufarROW][nenufarCOL] = redfrog;
				redSapo.setRow(nenufarROW);
				redSapo.setCol(nenufarCOL);
				redSapo.setPulou(true);
			} else if (tabuleiro[rowTabuleiro][colTabuleiro].equals(yellowfrog)) {
				verificaGhostFrog(0, 1);
				lastYellowSapoRow = rowTabuleiro;
				lastYellowSapoCol = colTabuleiro;
				tabuleiro[lastYellowSapoRow][lastYellowSapoCol] = yellowSapo.getYellowGhostFrog();
				tabuleiro[nenufarROW][nenufarCOL] = yellowfrog;
				yellowSapo.setRow(nenufarROW);
				yellowSapo.setCol(nenufarCOL);
				yellowSapo.setPulou(true);
			}
			lastTabROW = rowTabuleiro;
			lastTabCOL = colTabuleiro;
		}
	}

	public void desfazerMoverSapo() {
		if (tabuleiro[nenufarROW][nenufarCOL].equals(redfrog)) {
			tabuleiro[lastTabROW][lastTabCOL] = redfrog;
			tabuleiro[nenufarROW][nenufarCOL] = nenufar;
			redSapo.setRow(lastTabROW);
			redSapo.setCol(lastTabCOL);
		} else if (tabuleiro[nenufarROW][nenufarCOL].equals(yellowfrog)) {
			tabuleiro[lastTabROW][lastTabCOL] = yellowfrog;
			tabuleiro[lastTabROW][lastTabCOL] = nenufar;
			yellowSapo.setRow(lastTabROW);
			yellowSapo.setCol(lastTabCOL);
		}
	}

	public void refazerMoverSapo() {
		if (tabuleiro[lastTabROW][lastTabCOL].equals(redfrog)) {
			tabuleiro[lastTabROW][lastTabCOL] = nenufar;
			tabuleiro[nenufarROW][nenufarCOL] = redfrog;
			redSapo.setRow(nenufarROW);
			redSapo.setCol(nenufarCOL);
		} else if (tabuleiro[lastTabROW][lastTabCOL].equals(yellowfrog)) {
			tabuleiro[lastTabROW][lastTabCOL] = nenufar;
			tabuleiro[lastTabROW][lastTabCOL] = yellowfrog;
			yellowSapo.setRow(lastTabROW);
			yellowSapo.setCol(lastTabCOL);
		}
	}

	public void verificaGhostFrog(int n1, int n2) {
		if (n1 == 1 && tabuleiro[lastRedSapoRow][lastRedSapoCol].equals(redSapo.getRedGhostFrog())) {
			tabuleiro[lastRedSapoRow][lastRedSapoCol] = nenufar;
		}
		if (n2 == 1 && tabuleiro[lastYellowSapoRow][lastYellowSapoCol].equals(yellowSapo.getYellowGhostFrog())) {
			tabuleiro[lastYellowSapoRow][lastYellowSapoCol] = nenufar;
		}
	}

	public void posicionarVermelha() {
		verificaGhostFrog(1, 1);
		if (!redtabuleiro[2][2].equals(mostrar)) {
			if (empate) {
				movimentoEmpate();
			} else {
				if (redPlayer.getStatus() == 1) {
					if (rowTabuleiro == darknenufarRow && colTabuleiro == darknenufarCol) {
						tabuleiro[rowTabuleiro][colTabuleiro] = nenufarredflower;
						redtabuleiro[2][2] = mostrar;
						redPlayer.setStatus(0);
						// COMPOSITE
						jogadas.getParticipante(0).setJogadas(1);
						proximaEtapa();
					}
				} else if (redPlayer.getStatus() == 2 && tabuleiro[rowTabuleiro][colTabuleiro].equals(nenufar)) {
					tabuleiro[rowTabuleiro][colTabuleiro] = nenufarredflower;
					redtabuleiro[2][2] = mostrar;
					lastRedROW = rowTabuleiro;
					lastRedCOL = colTabuleiro;
					redPlayer.setPosicionou(true);
					// COMPOSITE
					jogadas.getParticipante(1).setJogadas(2);
					proximaEtapa();
				}
			}
		}
	}

	public void desfazerposicionarVermelha() {
		if (redPlayer.getStatus() == 2) {
			tabuleiro[lastRedROW][lastRedCOL] = nenufar;
			redtabuleiro[2][2] = temporaria;
		}
	}

	public void refazerposicionarVermelha() {
		if (redPlayer.getStatus() == 2) {
			tabuleiro[lastRedROW][lastRedCOL] = nenufarredflower;
			redtabuleiro[2][2] = mostrar;
		}
	}

	public void posicionarAmarela() {
		verificaGhostFrog(1, 1);
		if (!yellowtabuleiro[2][0].equals(mostrar)) {
			if (empate) {
				movimentoEmpate();
			} else {
				if (yellowPlayer.getStatus() == 1) {
					if (rowTabuleiro == darknenufarRow && colTabuleiro == darknenufarCol) {
						tabuleiro[rowTabuleiro][colTabuleiro] = nenufaryellowflower;
						yellowtabuleiro[2][0] = mostrar;
						yellowPlayer.setStatus(0);
						// COMPOSITE
						jogadas.getParticipante(0).setJogadas(1);
						proximaEtapa();
					}
				} else if (yellowPlayer.getStatus() == 2 && tabuleiro[rowTabuleiro][colTabuleiro].equals(nenufar)) {
					tabuleiro[rowTabuleiro][colTabuleiro] = nenufaryellowflower;
					yellowtabuleiro[2][0] = mostrar;
					lastYelROW = rowTabuleiro;
					lastYelCOL = colTabuleiro;
					yellowPlayer.setPosicionou(true);
					// COMPOSITE
					jogadas.getParticipante(1).setJogadas(2);
					proximaEtapa();
				}
			}
		}
	}

	public void desfazerposicionarAmarela() {
		if (yellowPlayer.getStatus() == 2) {
			tabuleiro[lastYelROW][lastYelCOL] = nenufar;
			yellowtabuleiro[2][0] = temporaria;
		}
	}

	public void refazerposicionarAmarela() {
		if (yellowPlayer.getStatus() == 2) {
			tabuleiro[lastYelROW][lastYelCOL] = nenufarredflower;
			yellowtabuleiro[2][0] = mostrar;
		}
	}

	public void ventoPrimaveraLEFT() {
		int position = -1;
		redSapoBoolean = false;
		yellowSapoBoolean = false;
		if ((yellowtabuleiro[2][0].equals(mostrar)) && (redtabuleiro[2][2].equals(mostrar))) {
			if ((!tabuleiro[rowTabuleiro][colTabuleiro].equals(agua)) && (colTabuleiro - 1) >= 0) {
				if (tabuleiro[rowTabuleiro][colTabuleiro - 1].equals(agua)) {
					lastTabROW = rowTabuleiro;
					lastTabCOL = colTabuleiro;
					buscadorDeSapo(0, -1);
					ventoTemp = colTabuleiro - 1;
					tabuleiro[rowTabuleiro][colTabuleiro - 1] = tabuleiro[rowTabuleiro][colTabuleiro].toString();
					tabuleiro[rowTabuleiro][colTabuleiro] = agua;
				} else {
					for (int i = colTabuleiro; i >= 0; i--) {
						if (tabuleiro[rowTabuleiro][i].equals(agua)) {
							position = i;
							ventoTemp = position;
							break;
						}
					}
					if (position > -1) {
						lastTabROW = rowTabuleiro;
						lastTabCOL = colTabuleiro;
						for (int i = lastTabCOL; i >= 0; i--) {
							if (tabuleiro[lastTabROW][i].equals(redfrog)) {
								redSapo.setCol(i - 1);
								redSapoBoolean = true;
							}
							if (tabuleiro[lastTabROW][i].equals(yellowfrog)) {
								yellowSapo.setCol(i - 1);
								yellowSapoBoolean = true;
							}
						}
						while (position < colTabuleiro) {
							tabuleiro[rowTabuleiro][position] = tabuleiro[rowTabuleiro][position + 1];
							position++;
						}
						tabuleiro[rowTabuleiro][colTabuleiro] = agua;
					}
				}
			}
		}
		verificaPontos();
	}

	public void desfazerLEFT() {
		if (tabuleiro[lastTabROW][ventoTemp + 1].equals(agua)) {
			tabuleiro[lastTabROW][ventoTemp + 1] = tabuleiro[lastTabROW][ventoTemp];
			tabuleiro[lastTabROW][ventoTemp] = agua;
		} else {
			int coluna = lastTabCOL;
			while (coluna > ventoTemp) {
				tabuleiro[lastTabROW][coluna] = tabuleiro[lastTabROW][coluna - 1];
				coluna--;
			}
			tabuleiro[lastTabROW][ventoTemp] = agua;
		}
		if (redSapoBoolean) {
			int n = redSapo.getCol();
			n++;
			redSapo.setCol(n);
		}
		if (yellowSapoBoolean) {
			int n1 = yellowSapo.getCol();
			n1++;
			yellowSapo.setCol(n1);
		}
	}

	public void refazerLEFT() {
		if (tabuleiro[lastTabROW][lastTabCOL - 1].equals(agua)) {
			tabuleiro[lastTabROW][lastTabCOL - 1] = tabuleiro[lastTabROW][lastTabCOL];
			tabuleiro[lastTabROW][lastTabCOL] = agua;
		} else {
			while (ventoTemp < lastTabCOL) {
				tabuleiro[lastTabROW][ventoTemp] = tabuleiro[lastTabROW][ventoTemp + 1];
				ventoTemp++;
			}
			tabuleiro[lastTabROW][lastTabCOL] = agua;
		}
		/*
		 * if (redSapoBoolean) { redsapoCOL--; System.out.println("redsapo: " +
		 * redsapoROW + "." + redsapoCOL); } if (yellowSapoBoolean) { yellowsapoCOL--;
		 * System.out.println("yellowsapo: " + yellowsapoROW + "." + yellowsapoCOL); }
		 */
	}

	public void desfazerDOWN() {
		if (tabuleiro[ventoTemp - 1][lastTabCOL].equals(agua)) {
			tabuleiro[ventoTemp - 1][lastTabCOL] = tabuleiro[ventoTemp][lastTabCOL];
			tabuleiro[ventoTemp][lastTabCOL] = agua;
		} else {
			int linha = lastTabROW;
			while (linha < ventoTemp) {
				tabuleiro[linha][lastTabCOL] = tabuleiro[linha + 1][lastTabCOL];
				linha++;
			}
			tabuleiro[ventoTemp][lastTabCOL] = agua;
		}
		/*
		 * if (redSapoBoolean) { redsapoROW--; System.out.println("redsapo: " +
		 * redsapoROW + "." + redsapoCOL); } if (yellowSapoBoolean) { yellowsapoROW--;
		 * System.out.println("yellowsapo: " + yellowsapoROW + "." + yellowsapoCOL); }
		 */
	}

	public void refazerDOWN() {
		if (tabuleiro[lastTabROW + 1][lastTabCOL].equals(agua)) {
			tabuleiro[lastTabROW + 1][lastTabCOL] = tabuleiro[lastTabROW][lastTabCOL];
			tabuleiro[lastTabROW][lastTabCOL] = agua;
		} else {
			while (ventoTemp > lastTabROW) {
				tabuleiro[ventoTemp][lastTabCOL] = tabuleiro[ventoTemp - 1][lastTabCOL];
				ventoTemp--;
			}
			tabuleiro[lastTabROW][lastTabCOL] = agua;
		}
		/*
		 * if (redSapoBoolean) { redsapoROW++; System.out.println("redsapo: " +
		 * redsapoROW + "." + redsapoCOL); } if (yellowSapoBoolean) { yellowsapoROW++;
		 * System.out.println("yellowsapo: " + yellowsapoROW + "." + yellowsapoCOL); }
		 */
	}

	public void ventoPrimaveraDOWN() {
		int position = -1;
		redSapoBoolean = false;
		yellowSapoBoolean = false;
		if ((yellowtabuleiro[2][0].equals(mostrar)) && (redtabuleiro[2][2].equals(mostrar))) {
			if ((!tabuleiro[rowTabuleiro][colTabuleiro].equals(agua)) && (rowTabuleiro + 1) <= 4) {
				if (tabuleiro[rowTabuleiro + 1][colTabuleiro].equals(agua)) {
					lastTabROW = rowTabuleiro;
					lastTabCOL = colTabuleiro;
					buscadorDeSapo(1, 0);
					ventoTemp = rowTabuleiro + 1;
					tabuleiro[rowTabuleiro + 1][colTabuleiro] = tabuleiro[rowTabuleiro][colTabuleiro].toString();
					tabuleiro[rowTabuleiro][colTabuleiro] = agua;
				} else {
					for (int i = rowTabuleiro + 1; i <= 4; i++) {
						if (tabuleiro[i][colTabuleiro].equals(agua)) {
							position = i;
							ventoTemp = position;
							break;
						}
					}
					if (position > -1) {
						lastTabROW = rowTabuleiro;
						lastTabCOL = colTabuleiro;
						for (int i = lastTabROW; i <= 4; i++) {
							if (tabuleiro[i][lastTabCOL].equals(redfrog)) {
								redSapo.setRow(i + 1);
								redSapoBoolean = true;
							}
							if (tabuleiro[i][lastTabCOL].equals(yellowfrog)) {
								yellowSapo.setRow(i + 1);
								yellowSapoBoolean = true;
							}
						}
						while (position > rowTabuleiro) {
							tabuleiro[position][colTabuleiro] = tabuleiro[position - 1][colTabuleiro];
							position--;
						}
						tabuleiro[rowTabuleiro][colTabuleiro] = agua;
					}
				}
			}
		}
		verificaPontos();
	}

	public void desfazerRIGHT() {
		if (tabuleiro[lastTabROW][ventoTemp - 1].equals(agua)) {
			tabuleiro[lastTabROW][ventoTemp - 1] = tabuleiro[lastTabROW][ventoTemp];
			tabuleiro[lastTabROW][ventoTemp] = agua;
		} else {
			int coluna = lastTabCOL;
			while (coluna < ventoTemp) {
				tabuleiro[lastTabROW][coluna] = tabuleiro[lastTabROW][coluna + 1];
				coluna++;
			}
			tabuleiro[lastTabROW][ventoTemp] = agua;
		}
		/*
		 * if (redSapoBoolean) { redsapoCOL--; System.out.println("redsapo: " +
		 * redsapoROW + "." + redsapoCOL); } if (yellowSapoBoolean) { yellowsapoCOL--;
		 * System.out.println("yellowsapo: " + yellowsapoROW + "." + yellowsapoCOL); }
		 */
	}

	public void refazerRIGHT() {
		if (tabuleiro[lastTabROW][lastTabCOL + 1].equals(agua)) {
			tabuleiro[lastTabROW][lastTabCOL + 1] = tabuleiro[lastTabROW][lastTabCOL];
			tabuleiro[lastTabROW][lastTabCOL] = agua;
		} else {
			while (ventoTemp > lastTabCOL) {
				tabuleiro[lastTabROW][ventoTemp] = tabuleiro[lastTabROW][ventoTemp - 1];
				ventoTemp--;
			}
			tabuleiro[lastTabROW][lastTabCOL] = agua;
		}
		/*
		 * if (redSapoBoolean) { redsapoCOL++; System.out.println("redsapo: " +
		 * redsapoROW + "." + redsapoCOL); } if (yellowSapoBoolean) { yellowsapoCOL++;
		 * System.out.println("yellowsapo: " + yellowsapoROW + "." + yellowsapoCOL); }
		 */
	}

	public void ventoPrimaveraRIGHT() {
		int position = -1;
		redSapoBoolean = false;
		yellowSapoBoolean = false;
		if ((yellowtabuleiro[2][0].equals(mostrar)) && (redtabuleiro[2][2].equals(mostrar))) {
			if ((!tabuleiro[rowTabuleiro][colTabuleiro].equals(agua)) && (colTabuleiro + 1) <= 4) {
				if (tabuleiro[rowTabuleiro][colTabuleiro + 1].equals(agua)) {
					lastTabROW = rowTabuleiro;
					lastTabCOL = colTabuleiro;
					buscadorDeSapo(0, 1);
					ventoTemp = colTabuleiro + 1;
					tabuleiro[rowTabuleiro][colTabuleiro + 1] = tabuleiro[rowTabuleiro][colTabuleiro].toString();
					tabuleiro[rowTabuleiro][colTabuleiro] = agua;
				} else {
					for (int i = colTabuleiro + 1; i < 5; i++) {
						if (tabuleiro[rowTabuleiro][i].equals(agua)) {
							position = i;
							ventoTemp = position;
							break;
						}
					}
					if (position > -1) {
						lastTabROW = rowTabuleiro;
						lastTabCOL = colTabuleiro;
						for (int i = lastTabCOL; i <= 4; i++) {
							if (tabuleiro[lastTabROW][i].equals(redfrog)) {
								redSapo.setCol(i + 1);
								redSapoBoolean = true;
							}
							if (tabuleiro[lastTabROW][i].equals(yellowfrog)) {
								yellowSapo.setCol(i + 1);
								yellowSapoBoolean = true;
							}
						}
						while (position > colTabuleiro) {
							tabuleiro[lastTabROW][position] = tabuleiro[lastTabROW][position - 1];
							position--;
						}
						tabuleiro[lastTabROW][lastTabCOL] = agua;
					}
				}
			}
		}
		verificaPontos();
	}

	public void ventoPrimaveraUP() {
		int position = -1;
		redSapoBoolean = false;
		yellowSapoBoolean = false;
		if ((yellowtabuleiro[2][0].equals(mostrar)) && (redtabuleiro[2][2].equals(mostrar))) {
			if ((!tabuleiro[rowTabuleiro][colTabuleiro].equals(agua)) && (rowTabuleiro - 1) >= 0) {
				if (tabuleiro[rowTabuleiro - 1][colTabuleiro].equals(agua)) {
					lastTabROW = rowTabuleiro;
					lastTabCOL = colTabuleiro;
					buscadorDeSapo(-1, 0);
					ventoTemp = rowTabuleiro - 1;
					tabuleiro[rowTabuleiro - 1][colTabuleiro] = tabuleiro[rowTabuleiro][colTabuleiro].toString();
					tabuleiro[rowTabuleiro][colTabuleiro] = agua;
				} else {
					for (int i = rowTabuleiro - 1; i >= 0; i--) {
						if (tabuleiro[i][colTabuleiro].equals(agua)) {
							position = i;
							ventoTemp = position;
							break;
						}
					}
					if (position > -1) {
						lastTabROW = rowTabuleiro;
						lastTabCOL = colTabuleiro;
						for (int i = lastTabROW; i >= 0; i--) {
							if (tabuleiro[i][lastTabCOL].equals(redfrog)) {
								redSapo.setRow(i - 1);
								redSapoBoolean = true;
							}
							if (tabuleiro[i][lastTabCOL].equals(yellowfrog)) {
								yellowSapo.setRow(i - 1);
								yellowSapoBoolean = true;
							}
						}
						while (position < lastTabROW) {
							tabuleiro[position][lastTabCOL] = tabuleiro[position + 1][lastTabCOL];
							position++;
						}
						tabuleiro[lastTabROW][lastTabCOL] = agua;
					}
				}
			}
		}
		verificaPontos();
	}

	private void buscadorDeSapo(int m, int n) {
		if (tabuleiro[lastTabROW][lastTabCOL].equals(redfrog)) {
			redSapo.setRow(lastTabROW + m);
			redSapo.setCol(lastTabCOL + n);
			redSapoBoolean = true;
		} else if (tabuleiro[lastTabROW][lastTabCOL].equals(yellowfrog)) {
			yellowSapo.setRow(lastTabROW + m);
			yellowSapo.setCol(lastTabCOL + n);
			yellowSapoBoolean = true;
		}
	}

	public void desfazerUP() {
		if (tabuleiro[ventoTemp + 1][lastTabCOL].equals(agua)) {
			tabuleiro[ventoTemp + 1][lastTabCOL] = tabuleiro[ventoTemp][lastTabCOL];
			tabuleiro[ventoTemp][lastTabCOL] = agua;
		} else {
			int linha = lastTabROW;
			while (linha > ventoTemp) {
				tabuleiro[linha][lastTabCOL] = tabuleiro[linha - 1][lastTabCOL];
				linha--;
			}
			tabuleiro[ventoTemp][lastTabCOL] = agua;
		}
		/*
		 * if (redSapoBoolean) { redsapoROW++; System.out.println("redsapo: " +
		 * redsapoROW + "." + redsapoCOL); } if (yellowSapoBoolean) { yellowsapoROW++;
		 * System.out.println("yellowsapo: " + yellowsapoROW + "." + yellowsapoCOL); }
		 */
	}

	public void refazerUP() {
		if (tabuleiro[lastTabROW - 1][lastTabCOL].equals(agua)) {
			tabuleiro[lastTabROW - 1][lastTabCOL] = tabuleiro[lastTabROW][lastTabCOL];
			tabuleiro[lastTabROW][lastTabCOL] = agua;
		} else {
			while (ventoTemp < lastTabROW) {
				tabuleiro[ventoTemp][lastTabCOL] = tabuleiro[ventoTemp + 1][lastTabCOL];
				ventoTemp++;
			}
			tabuleiro[lastTabROW][lastTabCOL] = agua;
		}
		/*
		 * if (redSapoBoolean) { redsapoROW--; System.out.println("redsapo: " +
		 * redsapoROW + "." + redsapoCOL); } if (yellowSapoBoolean) { yellowsapoROW--;
		 * System.out.println("yellowsapo: " + yellowsapoROW + "." + yellowsapoCOL); }
		 */
	}

	public void verificaPontos() {
		// STRATEGY
		pontuador = new Pontuador();
		board = new Board(tabuleiro, nenufarredflower, nenufaryellowflower);
		calculaPontos = new CalculaPontos();
		calculaPontos.calculaTabuleiro(board);
		pontuador.addRED(calculaPontos.getRedPoints());
		pontuador.addYELLOW(calculaPontos.getYellowPoints());

		int redPoints = pontuador.getTotalRED();
		int yellowPoints = pontuador.getTotalYELLOW();

		if (pontosTabuleiro[0][0].equals(red) && redPoints > 0) {
			if (redPoints == 1) {
				pontosTabuleiro[1][0] = red;
				redPlayer.setPontos(1);
			} else if (redPoints == 2) {
				pontosTabuleiro[0][1] = red;
				redPlayer.setPontos(2);
			} else if (redPoints == 3) {
				pontosTabuleiro[1][2] = red;
				redPlayer.setPontos(3);
			} else if (redPoints >= 5) {
				pontosTabuleiro[1][4] = red;
				redPlayer.setPontos(redPoints);
			}
			pontosTabuleiro[0][0] = mato;
		} else if (pontosTabuleiro[1][0].equals(red) && redPoints > 0) {
			if (redPoints == 1) {
				pontosTabuleiro[0][1] = red;
				redPlayer.setPontos(1);
			} else if (redPoints == 2) {
				pontosTabuleiro[1][2] = red;
				redPlayer.setPontos(2);
			} else if (redPoints == 3) {
				pontosTabuleiro[0][3] = red;
				redPlayer.setPontos(3);
			} else if (redPoints >= 5) {
				pontosTabuleiro[1][4] = red;
				redPlayer.setPontos(redPoints);
			}
			pontosTabuleiro[1][0] = um;
		} else if (pontosTabuleiro[0][1].equals(red) && redPoints > 0) {
			if (redPoints == 1) {
				pontosTabuleiro[1][2] = red;
				redPlayer.setPontos(1);
			} else if (redPoints == 2) {
				pontosTabuleiro[0][3] = red;
				redPlayer.setPontos(2);
			} else if (redPoints >= 3) {
				pontosTabuleiro[1][4] = red;
				redPlayer.setPontos(redPoints);
			}
			pontosTabuleiro[0][1] = dois;
		} else if (pontosTabuleiro[1][2].equals(red) && redPoints > 0) {
			if (redPoints == 1) {
				pontosTabuleiro[0][3] = red;
				redPlayer.setPontos(1);
			} else if (redPoints >= 2) {
				pontosTabuleiro[1][4] = red;
				redPlayer.setPontos(redPoints);
			}
			pontosTabuleiro[1][2] = tres;
		} else if (pontosTabuleiro[0][3].equals(red) && redPoints > 0) {
			if (redPoints >= 1) {
				pontosTabuleiro[1][4] = red;
				redPlayer.setPontos(redPoints);
			}
			pontosTabuleiro[0][3] = quatro;
		} else {
			redPlayer.setPontos(redPoints);
		}

		if (pontosTabuleiro[0][8].equals(yellow) && yellowPoints > 0) {
			if (yellowPoints == 1) {
				pontosTabuleiro[1][8] = yellow;
				yellowPlayer.setPontos(1);
			} else if (yellowPoints == 2) {
				pontosTabuleiro[0][7] = yellow;
				yellowPlayer.setPontos(2);
			} else if (yellowPoints == 3) {
				pontosTabuleiro[1][6] = yellow;
				yellowPlayer.setPontos(3);
			} else if (yellowPoints >= 5) {
				pontosTabuleiro[1][4] = yellow;
				yellowPlayer.setPontos(yellowPoints);
			}
			pontosTabuleiro[0][8] = mato;
		} else if (pontosTabuleiro[1][8].equals(yellow) && yellowPoints > 0) {
			if (yellowPoints == 1) {
				pontosTabuleiro[0][7] = yellow;
				yellowPlayer.setPontos(1);
			} else if (yellowPoints == 2) {
				pontosTabuleiro[1][6] = yellow;
				yellowPlayer.setPontos(2);
			} else if (yellowPoints == 3) {
				pontosTabuleiro[0][5] = yellow;
				yellowPlayer.setPontos(3);
			} else if (yellowPoints >= 5) {
				pontosTabuleiro[1][4] = yellow;
				yellowPlayer.setPontos(yellowPoints);
			}
			pontosTabuleiro[1][8] = um;
		} else if (pontosTabuleiro[0][7].equals(yellow) && yellowPoints > 0) {
			if (yellowPoints == 1) {
				pontosTabuleiro[1][6] = yellow;
				yellowPlayer.setPontos(1);
			} else if (yellowPoints == 2) {
				pontosTabuleiro[0][5] = yellow;
				yellowPlayer.setPontos(2);
			} else if (yellowPoints >= 3) {
				pontosTabuleiro[1][4] = yellow;
				yellowPlayer.setPontos(yellowPoints);
			}
			pontosTabuleiro[0][7] = dois;
		} else if (pontosTabuleiro[1][6].equals(yellow) && yellowPoints > 0) {
			if (yellowPoints == 1) {
				pontosTabuleiro[0][5] = yellow;
				yellowPlayer.setPontos(1);
			} else if (yellowPoints >= 2) {
				pontosTabuleiro[1][4] = yellow;
				yellowPlayer.setPontos(yellowPoints);
			}
			pontosTabuleiro[1][6] = tres;
		} else if (pontosTabuleiro[0][5].equals(yellow) && yellowPoints > 0) {
			if (yellowPoints >= 1) {
				pontosTabuleiro[1][4] = yellow;
				yellowPlayer.setPontos(yellowPoints);
			}
			pontosTabuleiro[0][5] = quatro;
		} else {
			yellowPlayer.setPontos(yellowPoints);
		}
		// COMPOSITE
		jogadas.getParticipante(0).setJogadas(0);

		notificarMudancaTabuleiro();

		if ((redPlayer.getPontos() >= 5 || yellowPlayer.getPontos() >= 5)
				&& (redPlayer.getPontos() != yellowPlayer.getPontos())) {
			fimDeJogo();
		} else {
			acabouRodada();
		}
	}

	public void acabouRodada() {
		// VISITOR
		placar.visitRedPlayer(redPlayer);
		placar.visitYellowPlayer(yellowPlayer);
		if (placar.getRedMark() > placar.getRedpontos()) {
			placar.setRedpontos();
			if (placar.getYellowMark() > placar.getYellowpontos()) {
				placar.setYellowpontos();
			}
			fimRodada = false;
			inicializar();
			resetState();
		} else if (placar.getYellowMark() > placar.getYellowpontos()) {
			placar.setYellowpontos();
			if (placar.getRedMark() > placar.getRedpontos()) {
				placar.setRedpontos();
			}
			fimRodada = false;
			inicializar();
			resetState();
		} else {
			// ACABARAM AS CARTAS???
			int n = 0;
			for (int i = 0; i < 3; i++) {
				if (redtabuleiro[3][i].equals(haru) && yellowtabuleiro[3][i].equals(haru)) {
					n++;
					fimRodada = true;
				}
			}
			if (n == 3) {
				inicializar();
				resetState();
			} else {
				if (redLastPlay && yellowLastPlay) {
					tabuleiro[redSapo.getRow()][redSapo.getCol()] = nenufar;
					tabuleiro[yellowSapo.getRow()][yellowSapo.getCol()] = nenufar;
				}
				redPlayer.setVentou(true);
				yellowPlayer.setVentou(true);
				proximaEtapa();
			}
		}
	}

	public void setarDarkNenufarR() {
		verificaGhostFrog(1, 1);
		if (!(tabuleiro[darknenufarRow][darknenufarCol].equals(darknenufar))) {
			if ((redPlayer.getStatus() == 2 && tabuleiro[rowTabuleiro][colTabuleiro].equals(nenufar))) {
				darknenufarRow = rowTabuleiro;
				darknenufarCol = colTabuleiro;
				lastTabROW = rowTabuleiro;
				lastTabCOL = colTabuleiro;
				tabuleiro[darknenufarRow][darknenufarCol] = darknenufar;
				redPlayer.setSetoudark(true);
				jogadas.getParticipante(1).setJogadas(0);
				proximaEtapa();
			}
		}
	}

	public void desfazersetarDarkNenufar() {
		tabuleiro[lastTabROW][lastTabCOL] = nenufar;
	}

	public void refazersetarDarkNenufar() {
		tabuleiro[lastTabROW][lastTabCOL] = darknenufar;
	}

	public void setarDarkNenufarY() {
		verificaGhostFrog(1, 1);
		if (!(tabuleiro[darknenufarRow][darknenufarCol].equals(darknenufar))) {
			if (yellowPlayer.getStatus() == 2 && tabuleiro[rowTabuleiro][colTabuleiro].equals(nenufar)) {
				darknenufarRow = rowTabuleiro;
				darknenufarCol = colTabuleiro;
				tabuleiro[darknenufarRow][darknenufarCol] = darknenufar;
				yellowPlayer.setSetoudark(true);
				jogadas.getParticipante(1).setJogadas(0);
				proximaEtapa();
			}
		}
	}

	public void removerSapos() {
		tabuleiro[redSapo.getRow()][redSapo.getCol()] = nenufar;
		tabuleiro[yellowSapo.getRow()][yellowSapo.getCol()] = nenufar;
	}

	/*
	 * public void desfazerRemoverSapos() { tabuleiro[redsapoROW][redsapoCOL] =
	 * redfrog; tabuleiro[yellowsapoROW][yellowsapoCOL] = yellowfrog; }
	 */
	public boolean isCondmostrarvermelha() {
		return condmostrarvermelha;
	}

	public boolean isEmpate() {
		return empate;
	}

	public boolean isRedLastPlay() {
		return redLastPlay;
	}

	public boolean isYellowLastPlay() {
		return yellowLastPlay;
	}

	public Player getRedPlayer() {
		return redPlayer;
	}

	public Player getYellowPlayer() {
		return yellowPlayer;
	}

	public Jogadas getJogadas() {
		return jogadas;
	}

	public boolean isCondmostraramarela() {
		return condmostraramarela;
	}

	public static String getRedgardner() {
		return redgardner;
	}

	public static String getYellowgardner() {
		return yellowgardner;
	}

	public static String getTrilha() {
		return trilha;
	}

	public boolean isRedFlowerOver() {
		return redFlowerOver;
	}

	public boolean isYellowFlowerOver() {
		return yellowFlowerOver;
	}

	public Object getPecaTabuleiro(int row, int col) {
		return (tabuleiro[row][col] == null ? null : tabuleiro[row][col]);
	}

	public Object getPecaRedTabuleiro(int row, int col) {
		return (redtabuleiro[row][col] == null ? null : redtabuleiro[row][col]);
	}

	public Object getPecaYellowTabuleiro(int row, int col) {
		return (yellowtabuleiro[row][col] == null ? null : yellowtabuleiro[row][col]);
	}

	public Object getPecaPontosTabuleiro(int row, int col) {
		return (pontosTabuleiro[row][col] == null ? null : pontosTabuleiro[row][col]);
	}

	@Override
	public void notificarMudancaTabuleiro() {
		for (Observador obs : observadores) {
			obs.mudouTabuleiro();
		}
	}

	@Override
	public void inicializar() {
		SetarTabuleiros();
	}

	@Override
	public void addObservador(Observador obs) {
		observadores.add(obs);
	}

	@Override
	public void removeObservador(Observador obs) {
		observadores.remove(obs);
	}

	@Override
	public void fimDeJogo() {
		for (Observador obs : observadores) {
			obs.fimJogo();
		}
	}

	public void proximaEtapa() {
		for (Observador obs : observadores) {
			obs.proximaEtapa();
		}
	}

	public void resetState() {
		for (Observador obs : observadores) {
			obs.novaRodada();
		}
	}

}
