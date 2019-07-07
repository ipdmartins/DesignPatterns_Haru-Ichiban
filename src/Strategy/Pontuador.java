/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ipdmartins
 */
public class Pontuador {
    
    private List<Integer> redPontos = new ArrayList<>();
    private List<Integer> yellowPontos = new ArrayList<>();

    public void addRED(int item) {
        redPontos.add(item);
    }
    
    public void addYELLOW(int item) {
        yellowPontos.add(item);
    }
    
    public int getTotalRED() {
        int res = 0;
        for (Integer item : redPontos) {
            res += item;
        }
        return res;
    }
    
    public int getTotalYELLOW() {
        int res = 0;
        for (Integer item : yellowPontos) {
            res += item;
        }
        return res;
    }
        
}
