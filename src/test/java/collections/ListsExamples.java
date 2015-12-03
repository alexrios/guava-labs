package collections;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ListsExamples {


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
    public void subList() throws Exception {
        List<List<Pessoa>> subList = Lists.partition(pessoaList, 2);
        assertThat(subList.size(), is(2));
    }
}
