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
public class VentoDown implements Command {

    private Controller control;

    public VentoDown(Controller control) {
        this.control = control;
    }

    @Override
    public void execute() {
        control.ventoPrimaveraDOWN();
    }

    @Override
    public void undo() {
        control.desfazerDOWN();
    }

    @Override
    public void redo() {
        control.refazerDOWN();
    }

}
