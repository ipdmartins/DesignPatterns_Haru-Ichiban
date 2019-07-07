/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

import control.Controller;
import control.Observador;
/**
 *
 * @author ipdmartins
 */
public class Jogo {
    
    private JogoEstado estado;
    private Controller control;
    private Observador tela;
    
    public Jogo(Observador Tela) {
        this.control = control.getInstance();
        this.tela = Tela;
        tela.habilitar("pegar");
        this.estado = new Pegar(this);
    }

    public void setEstadoAtual(JogoEstado estadoAtual) {
        this.estado = estadoAtual;
    }
    
    public void avancarEtapa() {
        this.estado.proxEtapa();
    }

    public Controller getControl() {
        return control;
    }

    public Observador getTela() {
        return tela;
    }

}
