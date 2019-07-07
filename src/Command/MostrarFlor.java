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
public class MostrarFlor implements Command{
    
    private Controller control;
    private boolean option;

    public MostrarFlor(Controller control, boolean option) {
        this.control = control;
        this.option = option;
    }
    
    @Override
    public void execute() {
        if(option){
            control.mostrarVermelha();
        }else{
            control.mostrarAmarela();
        }
    }

    @Override
    public void undo() {
        if(option){
            control.desfazerMostrarR();
        }else{
            control.desfazerMostrarY();
        }
    }

    @Override
    public void redo() {
        if(option){
            control.refazerMostrarR();
        }else{
            control.refazerMostrarY();
        }
    }
    
}
