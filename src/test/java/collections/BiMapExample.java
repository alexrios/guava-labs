package collections;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.junit.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BiMapExample {

    @Test(expected = IllegalArgumentException.class)
    public void lanca_excecao_quando_valor_nao_distinto() throws Exception {
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("1", "Tom");
        biMap.put("2", "Tom");
    }

    @Test
    public void forca_put() throws Exception {
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("1", "Tom");
        biMap.forcePut("2", "Tom");
        assertThat(biMap.containsKey("1"), is(FALSE));
        assertThat(biMap.containsKey("2"), is(TRUE));
    }

    @Test
    public void inverse() throws Exception {
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("1", "Tom");
        biMap.put("2", "Jerry");
        BiMap<String, String> inverse = biMap.inverse();

        assertThat(inverse.containsKey("Jerry"), is(TRUE));
        assertThat(inverse.get("Jerry"), is("2"));
    }
}
