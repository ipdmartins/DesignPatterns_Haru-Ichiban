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
public class SetarDarkNenufar implements Command {

    private Controller control;
    private boolean option;

    public SetarDarkNenufar(Controller control, boolean option) {
        this.control = control;
        this.option = option;
    }

    @Override
    public void execute() {
        if (option) {
            control.setarDarkNenufarR();
        } else {
            control.setarDarkNenufarY();
        }
    }

    @Override
    public void undo() {
        control.desfazersetarDarkNenufar();
    }

    @Override
    public void redo() {
        control.refazersetarDarkNenufar();
    }

}
