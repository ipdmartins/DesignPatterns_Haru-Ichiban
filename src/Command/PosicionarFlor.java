/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import control.Controller;

/**
 *
 * @author ipdmartins
 */
public class PosicionarFlor implements Command {

    private Controller control;
    private boolean option;

    public PosicionarFlor(Controller control, boolean option) {
        this.control = control;
        this.option = option;
    }

    @Override
    public void execute() {
        if (option) {
            control.posicionarVermelha();
        } else {
            control.posicionarAmarela();
        }
    }

    @Override
    public void undo() {
        if (option) {
            control.desfazerposicionarVermelha();
        } else {
            control.desfazerposicionarAmarela();
        }
    }

    @Override
    public void redo() {
        if (option) {
            control.refazerposicionarVermelha();
        } else {
            control.refazerposicionarAmarela();
        }
    }

}
