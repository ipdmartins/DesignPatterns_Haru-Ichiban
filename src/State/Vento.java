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
class Vento extends JogoEstado {

    public Vento(Jogo jogo) {
        super(jogo);
    }

    @Override
    public void proxEtapa() {
        if (this.jogo.getControl().getRedPlayer().getStatus() == 2) {
            this.jogo.getTela().habilitar("darkRed");
            this.jogo.setEstadoAtual(new RedSetDark(jogo));
        } else if (this.jogo.getControl().getYellowPlayer().getStatus() == 2) {
            this.jogo.getTela().habilitar("darkYellow");
            this.jogo.setEstadoAtual(new YellowSetDark(jogo));
        }
        this.jogo.getControl().getYellowPlayer().setVentou(false);
        this.jogo.getControl().getRedPlayer().setVentou(false);
    }

}
