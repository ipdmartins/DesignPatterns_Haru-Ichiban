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
class Mostrar extends JogoEstado {

    public Mostrar(Jogo jogo) {
        super(jogo);
    }

    @Override
    public void proxEtapa() {
        if(this.jogo.getControl().getRedPlayer().isMostrouFlor() && this.jogo.getControl().getYellowPlayer().isMostrouFlor()){
            this.jogo.getTela().habilitar("status");
            this.jogo.setEstadoAtual(new DefinirStatus(jogo));
            this.jogo.getControl().getRedPlayer().setMostrouFlor(false);
            this.jogo.getControl().getYellowPlayer().setMostrouFlor(false);
        }
    }
    
}
