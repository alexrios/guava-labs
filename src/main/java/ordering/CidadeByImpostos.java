package ordering;

import com.google.common.primitives.Doubles;

import java.util.Comparator;

public class CidadeByImpostos implements Comparator<Cidade> {

    public int compare(Cidade cidade1, Cidade cidade2) {
        return Doubles.compare(cidade1.getImposto(), cidade2.getImposto());
    }
}