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
public class VentoRight implements Command {

    private Controller control;

    public VentoRight(Controller control) {
        this.control = control;
    }

    @Override
    public void execute() {
        control.ventoPrimaveraRIGHT();
    }

    @Override
    public void undo() {
        control.desfazerRIGHT();
    }

    @Override
    public void redo() {
        control.refazerRIGHT();
    }

}
