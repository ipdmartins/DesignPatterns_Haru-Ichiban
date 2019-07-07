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
public class MoverSapo implements Command{

    private Controller control;
    private boolean option;

    public MoverSapo(Controller control, boolean option) {
        this.control = control;
        this.option = option;
    }
    
    @Override
    public void execute() {
        if(option){
            control.moverPecaR();
        }else{
            control.moverPecaY();
        }
    }

    @Override
    public void undo() {
        control.desfazerMoverSapo();
    }

    @Override
    public void redo() {
        control.refazerMoverSapo();
    }
    
}
