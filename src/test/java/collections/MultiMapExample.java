package collections;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class MultiMapExample {

    @Test
    public void mesma_chave() {
        ArrayListMultimap<String, String> multiMap = ArrayListMultimap.create();
        multiMap.put("Foo", "1");
        multiMap.put("Foo", "2");
        multiMap.put("Foo", "3");

        List<String> expected = Lists.newArrayList("1", "2", "3");
        assertEquals(multiMap.get("Foo"), expected);
    }

    @Test
    public void mesma_chave_e_valor() {
        ArrayListMultimap<String, String> multiMap = ArrayListMultimap.create();
        multiMap.put("Bar", "1");
        multiMap.put("Bar", "2");
        multiMap.put("Bar", "3");
        multiMap.put("Bar", "3");
        multiMap.put("Bar", "3");

        List<String> expected = Lists.newArrayList("1", "2", "3", "3", "3");
        assertEquals(multiMap.get("Bar"), expected);
    }
}
