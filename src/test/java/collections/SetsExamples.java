package collections;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SetsExamples {
    @Test
    public void diferenca_entre_conjuntos() throws Exception {
        Set<String> s1 = Sets.newHashSet("1", "2", "3");
        Set<String> s2 = Sets.newHashSet("2", "3", "4");
        assertThat(Sets.difference(s1, s2).size(), is(1));
    }

    @Test
    public void diferenca_entre_conjuntos_2() throws Exception {
        Set<String> s1 = Sets.newHashSet("1", "2", "3");
        Set<String> s2 = Sets.newHashSet("2", "3", "1");
        assertThat(Sets.difference(s1, s2).size(), is(0));
    }

    @Test
    public void diferenca_entre_conjuntos_3() throws Exception {
        Set<String> s1 = Sets.newHashSet("1", "2", "3", "4");
        Set<String> s2 = Sets.newHashSet("2", "3", "4");
        assertThat(Sets.difference(s1, s2).size(), is(1));
    }

    @Test
    public void diferenca_entre_conjuntos_4() throws Exception {
        Set<String> s1 = Sets.newHashSet("1", "2", "3");
        Set<String> s2 = Sets.newHashSet("1", "2", "3", "4");
        assertThat(Sets.difference(s1, s2).size(), is(0));
    }

    @Test
    public void diferenca_simetrica() throws Exception {
        Set<String> s1 = Sets.newHashSet("1", "2", "3");
        Set<String> s2 = Sets.newHashSet("1", "2", "3", "4");
        assertThat(Sets.symmetricDifference(s1, s2).size(), is(1));
        assertThat(Sets.symmetricDifference(s1, s2).toString(), is("[4]"));
    }

    @Test
    public void diferenca_simetrica_2() throws Exception {
        Set<String> s1 = Sets.newHashSet("1", "2", "3");
        Set<String> s2 = Sets.newHashSet("1", "2", "4");
        assertThat(Sets.symmetricDifference(s1, s2).size(), is(2));
        assertThat(Sets.symmetricDifference(s1, s2).toString(), is("[3, 4]"));
    }

    @Test
    public void intersecao() throws Exception {
        Set<String> s1 = Sets.newHashSet("1", "2", "3");
        Set<String> s2 = Sets.newHashSet("3", "2", "4");
        assertThat(Sets.intersection(s1, s2).size(), is(2));
        assertThat(Sets.intersection(s1, s2).toString(), is("[2, 3]"));
    }

    @Test
    public void uniao() throws Exception {
        Set<String> s1 = Sets.newHashSet("1", "2", "3");
        Set<String> s2 = Sets.newHashSet("3", "2", "4");
        assertThat(Sets.union(s1, s2).size(), is(4));
        assertThat(Sets.union(s1, s2).toString(), is("[1, 2, 3, 4]"));
    }
}
