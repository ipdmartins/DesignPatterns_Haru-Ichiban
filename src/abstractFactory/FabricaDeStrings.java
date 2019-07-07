/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractFactory;

import model.StringAdresser;
import model.Pontuacao;
import model.RedPlayer;
import model.Sound;
import model.YellowPlayer;

/**
 *
 * @author ipdmartins
 */
public abstract class FabricaDeStrings {

    public abstract StringAdresser buscarStringAdresser();
    
    public abstract RedPlayer buscarRedPlayer();
    
    public abstract YellowPlayer buscarYellowPlayer();

    public abstract Pontuacao buscarTrilhaPontuacao();
    
    public abstract Sound buscarSom();
}
