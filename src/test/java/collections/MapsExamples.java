package collections;


import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Boolean.TRUE;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MapsExamples {

//    List<Livro> livros = ...
//    Map<String,Livro> livroMap = new HashMap<String,Livro>()
//    for(Livro livro : livros){
//        livroMap.put(livro.getIsbn(), livro);
//    }

    @Test
    public void indexando() throws Exception {
        List<Livro> livros = ImmutableList.of(new Livro("10"), new Livro("20"));

        Map<String,Livro> livroMap = Maps.uniqueIndex(livros.iterator(), new Function<Livro, String>(){
                    public String apply( Livro input) {
                        return input.getIsbn();
                    }
                });

        assertThat(livroMap.keySet().size(), is(2));
        assertThat(livroMap.containsKey("10"), is(TRUE));
        assertThat(livroMap.containsKey("20"), is(TRUE));
    }

    @Test
    public void transformando_as_entradas() throws Exception {
        Map<String, Livro> livros = new HashMap<String, Livro>();
        livros.put("10", new Livro("10"));
        livros.put("20", new Livro("20"));


        Map<String, Livro> livroMap = Maps.transformEntries(livros, new Maps.EntryTransformer<String, Livro, Livro>() {
            public Livro transformEntry(String key, Livro value) {
                value.setIsbn(value.getIsbn() + 1);
                return value;
            }
        });

        assertThat(livroMap.keySet().size(), is(2));
        assertThat(livroMap.get("10").getIsbn(), is("101"));
        assertThat(livroMap.get("20").getIsbn(), is("201"));
    }

}

