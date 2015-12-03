package functional;

import com.google.common.base.Predicate;

public class RecargaPendente implements Predicate<Recarga> {

    public boolean apply(Recarga recarga) {
        return recarga.getStatus() == StatusRecarga.PENDENTE;
    }
}
