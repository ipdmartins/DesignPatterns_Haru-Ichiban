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
public class VentoUP implements Command {

    private Controller control;

    public VentoUP(Controller control) {
        this.control = control;
    }

    @Override
    public void execute() {
        control.ventoPrimaveraUP();
    }

    @Override
    public void undo() {
        control.desfazerUP();
    }

    @Override
    public void redo() {
        control.refazerUP();
    }

}
