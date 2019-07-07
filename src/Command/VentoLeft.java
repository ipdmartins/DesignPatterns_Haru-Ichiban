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
public class VentoLeft implements Command {

    private Controller control;

    public VentoLeft(Controller control) {
        this.control = control;

    }

    @Override
    public void execute() {
        control.ventoPrimaveraLEFT();
    }

    @Override
    public void undo() {
        control.desfazerLEFT();
    }

    @Override
    public void redo() {
        control.refazerLEFT();
    }

}
