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
class PosicionarRed extends JogoEstado {

    public PosicionarRed(Jogo jogo) {
        super(jogo);
    }

    @Override
    public void proxEtapa() {
        if (this.jogo.getControl().getYellowPlayer().getStatus() == 2) {
            this.jogo.getTela().habilitar("posisionarYS");
            this.jogo.setEstadoAtual(new PosicionarYellow(jogo));
            this.jogo.getControl().getRedPlayer().setPosicionou(false);
        }else if(this.jogo.getControl().getRedPlayer().getStatus() == 2) {
            this.jogo.getTela().habilitar("vento");
            this.jogo.setEstadoAtual(new Vento(jogo));
            this.jogo.getControl().getRedPlayer().setPosicionou(false);
        }
    }

}
