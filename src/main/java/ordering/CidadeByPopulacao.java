package ordering;

import com.google.common.primitives.Ints;

import java.util.Comparator;

public class CidadeByPopulacao implements Comparator<Cidade> {

    public int compare(Cidade cidade1, Cidade cidade2) {
        return Ints.compare(cidade1.getPopulacao(), cidade2.getPopulacao());
    }
}