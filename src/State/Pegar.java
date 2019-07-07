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
public class Pegar extends JogoEstado {

    public Pegar(Jogo jogo) {
        super(jogo);
    }
    
    @Override
    public void proxEtapa() {
        if(this.jogo.getControl().getRedPlayer().isPegouFlor() && this.jogo.getControl().getYellowPlayer().isPegouFlor()){
            this.jogo.getTela().habilitar("mostrar");
            this.jogo.setEstadoAtual(new Mostrar(jogo));
            this.jogo.getControl().getRedPlayer().setPegouFlor(false);
            this.jogo.getControl().getYellowPlayer().setPegouFlor(false);
        }
    }
    
}
