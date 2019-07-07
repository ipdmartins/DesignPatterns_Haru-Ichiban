/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractFactory;

import model.Pontuacao;
import model.RedPlayer;
import model.Sound;
import model.StringAdresser;
import model.YellowPlayer;

/**
 *
 * @author ipdmartins
 */
public class FabricaModelo extends FabricaDeStrings {

    @Override
    public StringAdresser buscarStringAdresser() {
        return new StringAdresser();
    }

    @Override
    public Pontuacao buscarTrilhaPontuacao() {
        return new Pontuacao();
    }

    @Override
    public Sound buscarSom() {
        return new Sound();
    }

    @Override
    public RedPlayer buscarRedPlayer() {
        return new RedPlayer();
    }

    @Override
    public YellowPlayer buscarYellowPlayer() {
        return new YellowPlayer();
    }

}
