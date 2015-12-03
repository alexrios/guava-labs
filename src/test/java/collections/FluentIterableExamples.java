package collections;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Iterables.contains;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FluentIterableExamples {

    private Pessoa pessoa1;
    private Pessoa pessoa2;
    private Pessoa pessoa3;
    private Pessoa pessoa4;
    private ArrayList<Pessoa> pessoaList;

    @Before
    public void setUp() {
        pessoa1 = new Pessoa("Wilma", "Flintstone", 30, "F");
        pessoa2 = new Pessoa("Fred", "Flintstone", 32, "M");
        pessoa3 = new Pessoa("Betty", "Rubble", 31, "F");
        pessoa4 = new Pessoa("Barney", "Rubble", 33, "M");
        pessoaList = Lists.newArrayList(pessoa1, pessoa2, pessoa3,
                pessoa4);
    }

    @Test
    public void filter() throws Exception {
        Iterable<Pessoa> filtradosPorIdade = FluentIterable.from(pessoaList).filter(new Predicate<Pessoa>() {
            public boolean apply(Pessoa p) {
                return p.getIdade() > 31;
            }
        });
        assertThat(contains(filtradosPorIdade, pessoa2), is(true));
        assertThat(contains(filtradosPorIdade, pessoa4), is(true));
        assertThat(contains(filtradosPorIdade, pessoa1), is(false));
        assertThat(contains(filtradosPorIdade, pessoa3), is(false));
    }

    @Test
    public void transform() throws Exception {
        List<String> transformados =
                FluentIterable.from(pessoaList).transform(new Function<Pessoa, String>() {
                    public String apply(Pessoa input) {
                        return Joiner.on('#').join(input.getSobrenome(),
                                input.getNome(), input.getIdade());
                    }
                }).toList();

        assertThat(transformados.get(1), is("Flintstone#Fred#32"));

    }
}
