package java8;

import collections.Pessoa;
import com.google.common.collect.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.transform;
import static com.google.common.collect.Maps.uniqueIndex;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class Java8 {

    private Pessoa pessoa1;
    private Pessoa pessoa2;
    private Pessoa pessoa3;
    private Pessoa pessoa4;
    private ArrayList<Pessoa> pessoas;


    @Before
    public void setUp() throws Exception {
        pessoa1 = new Pessoa("Wilma", "Flintstone", 30, "F");
        pessoa2 = new Pessoa("Fred", "Flintstone", 32, "M");
        pessoa3 = new Pessoa("Betty", "Rubble", 31, "F");
        pessoa4 = new Pessoa("Barney", "Rubble", 33, "M");
        pessoas = Lists.newArrayList(pessoa1, pessoa2, pessoa3,
                pessoa4);
    }

    @Test
    public void transformando() throws Exception {
        List<String> guavaList = transform(pessoas, x -> x.getNome());
        List<Object> javaList = pessoas.stream().map(x -> x.getNome()).collect(toList());

        assertEquals(guavaList, javaList);
    }

    @Test
    public void indexando() throws Exception {
        ImmutableMap<Integer, Pessoa> guavaMap = uniqueIndex(pessoas, x -> x.getIdade());
        Map<Pessoa, Integer> javaMap = pessoas.stream().collect(toMap(identity(), x -> x.getIdade()));

        assertTrue(guavaMap.values().containsAll(javaMap.keySet()));
    }


    @Test
    public void comparando_apis() throws Exception {
        ImmutableListMultimap<Integer, Pessoa> guavaMap = Multimaps.index(pessoas, x -> x.getIdade());
        Map<Integer, List<Pessoa>> javaMap = pessoas.stream().collect(Collectors.groupingBy(x -> x.getIdade()));

        assertEquals(guavaMap.keySet().size(), javaMap.keySet().size());
    }


    @Test
    public void obrigado_java8() throws Exception {
        ImmutableList<Pessoa> pessoas = FluentIterable.from(this.pessoas)
                .filter(x -> x.getIdade() > 30)
                .filter(x -> x.getIdade() % 2 == 0)
                .toList();

        assertThat(pessoas.size(), is(1));
    }

/**
 * - Preconditions vs java.util.Objects
 - Optionals
 - FluentIterable vs Streams
 - Joiner vs String.join (new StringJoiner vs stream.collect(Collectors.joining(separator)))
 - Predicates, Functions, Supliers
 - Ordering.natural() vs Comparator.naturalOrder()
 - Ordering.reverse() vs comparator.reversed()
 */

}
