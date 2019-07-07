/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;

/**
 *
 * @author ipdmartins
 */
public class Auxiliar {

    private String nome1 = null;
    private String nome2 = null;

    public String definirYellowPlayer() {
        while (nome1 == null || nome1.equals("")) {
            nome1 = JOptionPane.showInputDialog("Digite o nome do jardineiro amarelo");
            if ((nome1 == null || nome1.equals(""))) {
                JOptionPane.showMessageDialog(null, "Nome do jardineiro amarelo nao respondido");
            }
        }
        return nome1;
    }

    public String definirRedPlayer() {
        while (nome2 == null || nome2.equals("")) {
            nome2 = JOptionPane.showInputDialog("Digite o nome do jardineiro Vermelho");
            if ((nome2 == null || nome2.equals(""))) {
                JOptionPane.showMessageDialog(null, "Nome do jardineiro vermelho nao respondido");
            }
        }
        return nome2;
    }
}
