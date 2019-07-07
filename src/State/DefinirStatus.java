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
public class DefinirStatus extends JogoEstado {

    public DefinirStatus(Jogo jogo) {
        super(jogo);
    }

    @Override
    public void proxEtapa() {
        if (this.jogo.getControl().isEmpate()) {
            if (this.jogo.getControl().getRedPlayer().getStatus() == 2) {
                this.jogo.setEstadoAtual(new PosicionarRed(jogo));
            } else if (this.jogo.getControl().getYellowPlayer().getStatus() == 2) {
                this.jogo.setEstadoAtual(new PosicionarYellow(jogo));
            }
        } else if (this.jogo.getControl().getRedPlayer().isDefiniuSatus() && this.jogo.getControl().getYellowPlayer().isDefiniuSatus()) {
            if (this.jogo.getControl().getRedPlayer().getStatus() == 1) {
                this.jogo.getTela().habilitar("posisionarR");
                this.jogo.setEstadoAtual(new PosicionarRed(jogo));
            } else if (this.jogo.getControl().getYellowPlayer().getStatus() == 1) {
                this.jogo.getTela().habilitar("posisionarY");
                this.jogo.setEstadoAtual(new PosicionarYellow(jogo));
            }
            this.jogo.getControl().getRedPlayer().setDefiniuSatus(false);
            this.jogo.getControl().getYellowPlayer().setDefiniuSatus(false);
        }
    }

}
