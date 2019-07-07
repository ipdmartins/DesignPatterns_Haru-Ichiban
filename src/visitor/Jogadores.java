/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor;

import java.util.ArrayList;
import java.util.List;
import model.Player;

/**
 *
 * @author ipdmartins
 */
public class Jogadores {
    
    private List<Player> jogadores = new ArrayList<>();
    
    public void addIPlayer(Player player) {
        jogadores.add(player);
    }
    
    public void accept(Visitor visitor){
        for (Player player : jogadores) {
            player.accept(visitor);
        }
    }
}
