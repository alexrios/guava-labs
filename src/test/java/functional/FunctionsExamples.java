package functional;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.ImmutableSet;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FunctionsExamples {

    private HashMap<String, Servico> servicos;
    private Servico servicoExemplo;
    private Servico servicoDefault;

    @Before
    public void setUp() throws Exception {
        servicoExemplo = new Servico();
        servicoExemplo.setCodigo("1");
        servicoExemplo.setNome("OI MOVEL");
        servicoExemplo.setDdds(ImmutableSet.of("21", "41"));

        servicos = new HashMap<String, Servico>();
        servicos.put(servicoExemplo.getNome(), servicoExemplo);


        servicoDefault = new Servico();
        servicoDefault.setNome("DEFAULT");
    }

    @Test
    public void for_map() throws Exception {
        Function<String, Servico> mapFunction = Functions.forMap(servicos, servicoDefault);

        assertThat(mapFunction.apply("OI MOVEL"), is(servicoExemplo));
        assertThat(mapFunction.apply("NEXTEL"), is(servicoDefault));
    }

    @Test
    public void custom_fucntion() throws Exception {
        DDDsFunction function = new DDDsFunction();

        assertThat(function.apply(servicoExemplo), is("21;41"));
    }

    @Test
    public void compondo_funcoes() throws Exception {
        Function<String, Servico> mapFunction = Functions.forMap(servicos, servicoDefault);
        Function<Servico, String> dddsunction = new DDDsFunction();

        Function<String, String> composed = Functions.compose(dddsunction, mapFunction);

        assertThat(composed.apply("OI MOVEL"), is("21;41"));
    }


}
