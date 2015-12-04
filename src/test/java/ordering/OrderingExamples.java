package ordering;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OrderingExamples {

    private CidadeByPopulacao cidadeByPopulacao;
    private CidadeByImpostos cidadeByImpostos;

    @Before
    public void setUp() throws Exception {
        cidadeByPopulacao = new CidadeByPopulacao();
        cidadeByImpostos = new CidadeByImpostos();
    }

    @Test
    public void ordena_pela_populacao_reverse() throws Exception {
        Cidade cidade1 = new Cidade(11000, 55.0);
        Cidade cidade2 = new Cidade(8000, 45.0);
        Cidade cidade3 = new Cidade(10000, 33.8);

        List<Cidade> cidades = Lists.newArrayList(cidade1, cidade2, cidade3);
        Ordering<Cidade> reverse = Ordering.from(cidadeByPopulacao).reverse();
        Collections.sort(cidades, reverse);

        assertThat(cidades.get(0), is(cidade1));
    }

    @Test
    public void oredenacao_composta() {
        Cidade cidade1 = new Cidade(10000, 55.0);
        Cidade cidade2 = new Cidade(10000, 45.0);
        Cidade cidade3 = new Cidade(10000, 33.8);

        List<Cidade> cidades = Lists.newArrayList(cidade1, cidade2, cidade3);
        Ordering<Cidade> composto = Ordering.from(cidadeByPopulacao).compound(cidadeByImpostos);
        Collections.sort(cidades, composto);

        assertThat(cidades.get(0), is(cidade3));
    }

    @Test
    public void greatestOf() {
        Cidade cidade1 = new Cidade(10000, 55.0);
        Cidade cidade2 = new Cidade(9000, 45.0);
        Cidade cidade3 = new Cidade(8000, 33.8);

        List<Cidade> cidades = Lists.newArrayList(cidade1, cidade2, cidade3);
        Ordering<Cidade> byPopulation = Ordering.from(cidadeByPopulacao);

        List<Cidade> greatestPopulations = byPopulation.greatestOf(cidades, 2);

        assertThat(greatestPopulations.size(), is(2));
        assertThat(greatestPopulations.get(0), is(cidade1));
        assertThat(greatestPopulations.get(1), is(cidade2));
    }

    @Test
    public void leastOf() {
        Cidade cidade1 = new Cidade(10000, 55.0);
        Cidade cidade2 = new Cidade(9000, 45.0);
        Cidade cidade3 = new Cidade(8000, 33.8);

        List<Cidade> cidades = Lists.newArrayList(cidade1, cidade2, cidade3);
        Ordering<Cidade> byPopulation = Ordering.from(cidadeByPopulacao);

        List<Cidade> greatestPopulations = byPopulation.leastOf(cidades, 2);

        assertThat(greatestPopulations.size(), is(2));
        assertThat(greatestPopulations.get(0), is(cidade3));
        assertThat(greatestPopulations.get(1), is(cidade2));
    }


}
