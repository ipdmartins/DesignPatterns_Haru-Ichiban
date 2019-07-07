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
public class RedPlayer extends Player{
    
    public RedPlayer() {
        super();
        add("imagens/redFlowerUM.png");//0
        add("imagens/redFlowerDOIS.png");//1
        add("imagens/redFlowerTRES.png");//2
        add("imagens/redFlowerQUATRO.png");//3
        add("imagens/redFlowerCINCO.png");//4
        add("imagens/redFlowerSEIS.png");//5
        add("imagens/redFlowerSETE.png");//6
        add("imagens/redFlowerOITO.png");//7
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitRedPlayer(this);
    }
    
}
