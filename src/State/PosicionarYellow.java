/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

/**
 *
 * @author ipdmartins
 */
class PosicionarYellow extends JogoEstado {

    public PosicionarYellow(Jogo jogo) {
        super(jogo);
    }

    @Override
    public void proxEtapa() {
        if (this.jogo.getControl().getRedPlayer().getStatus() == 2) {
            this.jogo.getTela().habilitar("posisionarRS");
            this.jogo.setEstadoAtual(new PosicionarRed(jogo));
            this.jogo.getControl().getYellowPlayer().setPosicionou(false);
        }else if (this.jogo.getControl().getYellowPlayer().getStatus() == 2) {
            this.jogo.getTela().habilitar("vento");
            this.jogo.setEstadoAtual(new Vento(jogo));
            this.jogo.getControl().getYellowPlayer().setPosicionou(false);
        }
    }

}
