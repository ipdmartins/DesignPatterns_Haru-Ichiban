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
class YellowSetDark extends JogoEstado {

    public YellowSetDark(Jogo jogo) {
        super(jogo);
    }

    @Override
    public void proxEtapa() {
        if (this.jogo.getControl().getYellowPlayer().isSetoudark()) {
            if (!this.jogo.getControl().isRedFlowerOver() && !this.jogo.getControl().isYellowFlowerOver()) {
                this.jogo.getTela().habilitar("pegar");
                this.jogo.setEstadoAtual(new Pegar(jogo));
            }else{
                this.jogo.getTela().habilitar("mostrar");
                this.jogo.setEstadoAtual(new Mostrar(jogo));
            }
            this.jogo.getControl().getYellowPlayer().setSetoudark(false);
        }
    }
    
}
