package functional;

import com.google.common.base.Predicate;

public class RecargaZerada implements Predicate<Recarga> {

    public boolean apply(Recarga recarga) {
        return recarga.getValor() == 0;
    }
}
