package functional;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.junit.Before;
import org.junit.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PredicateExamples {

    private Recarga recargaComValor;
    private Recarga recargaZerada;

    @Before
    public void setUp() throws Exception {
        recargaComValor = new Recarga(10);
        recargaComValor.setStatus(StatusRecarga.PENDENTE);

        recargaZerada = new Recarga(0);
        recargaZerada.setStatus(StatusRecarga.DESFEITA);
    }

    @Test
    public void predicado_criado() throws Exception {
        RecargaZerada predicate = new RecargaZerada();

        assertThat(predicate.apply(recargaComValor), is(FALSE));
        assertThat(predicate.apply(recargaZerada), is(TRUE));
    }

    @Test
    public void compondo_predicados() throws Exception {
        Predicate<Recarga> recargaPredicate = Predicates.or(new RecargaZerada(), new RecargaPendente());

        assertThat(recargaPredicate.apply(recargaComValor), is(TRUE));
        assertThat(recargaPredicate.apply(recargaZerada), is(TRUE));
    }

    @Test
    public void negando_predicados() throws Exception {
        Predicate<Recarga> recargaPredicate = Predicates.not(new RecargaZerada());

        assertThat(recargaPredicate.apply(recargaComValor), is(TRUE));
        assertThat(recargaPredicate.apply(recargaZerada), is(FALSE));
    }
}
