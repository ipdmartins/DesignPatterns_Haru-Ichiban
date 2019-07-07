/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import abstractFactory.StringComum;
import java.util.ArrayList;
import java.util.List;
import visitor.Visitor;

/**
 *
 * @author ipdmartins
 */
public class YellowPlayer extends Player {
    
    public YellowPlayer() {
        super();
        add("imagens/yellowFlowerUM.png");
        add("imagens/yellowFlowerDOIS.png");
        add("imagens/yellowFlowerTRES.png");
        add("imagens/yellowFlowerQUATRO.png");
        add("imagens/yellowFlowerCINCO.png");
        add("imagens/yellowFlowerSEIS.png");
        add("imagens/yellowFlowerSETE.png");
        add("imagens/yellowFlowerOITO.png");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitYellowPlayer(this);
    }

}
