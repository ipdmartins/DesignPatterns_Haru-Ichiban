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
public class RemoverSapos implements Command {

    private Controller control;

    public RemoverSapos(Controller control) {
        this.control = control;
    }

    @Override
    public void execute() {
        control.removerSapos();
    }

    @Override
    public void undo() {
        control.desfazerMoverSapo();
    }

    @Override
    public void redo() {
        control.removerSapos();
    }

}
