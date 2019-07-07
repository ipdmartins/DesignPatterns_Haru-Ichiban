package model;

import abstractFactory.StringComum;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ipdmartins
 */
public class StringAdresser implements StringComum {

    private List<String> listaStrings;

    public StringAdresser() {
        this.listaStrings = new ArrayList<>();
        listaStrings.add("imagens/haru.png");
        listaStrings.add("imagens/trilha.png");
        listaStrings.add("imagens/redFlower.png");
        listaStrings.add("imagens/yellowFlower.png");
        listaStrings.add("imagens/redGardner.png");
        listaStrings.add("imagens/yellowGardner.png");
        listaStrings.add("imagens/mostrar.png");
    }

    @Override
    public String receberString(int num) {
        return listaStrings.get(num);
    }

}
