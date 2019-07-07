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
public class PegarFlor implements Command{

    private Controller control;
    private boolean option;

    public PegarFlor(Controller control, boolean opt) {
        this.control = control;
        this.option = opt;
    }
  
    @Override
    public void execute() {
        if(option){
            control.pegarRedFlower();
        }else{
            control.pegarYellowFlower();
        }
    }

    @Override
    public void undo() {
        System.out.println("Movimento não permitido");
    }

    @Override
    public void redo() {
        System.out.println("Movimento não permitido");
    }
    
}
