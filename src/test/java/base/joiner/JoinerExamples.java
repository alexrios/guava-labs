package base.joiner;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JoinerExamples {

    @Test
    public void substituindo_nulls() throws Exception {
        String result = Joiner.on("|")
                .useForNull("missing")
                .join("foo", "bar", "fizz", null);
        assertThat(result, is("foo|bar|fizz|missing"));
    }

    @Test
    public void desconsiderando_nulls() throws Exception {
        String result = Joiner.on("|")
                .skipNulls()
                .join("foo", "bar", null, "fizz");
        assertThat(result, is("foo|bar|fizz"));
    }

    @Test
    public void aproveitando_um_string_builder() throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        Joiner joiner = Joiner.on("|").skipNulls();
        joiner.appendTo(stringBuilder, "foo", "bar", "baz");

        assertThat(stringBuilder.toString(), is("foo|bar|baz"));

    }

    @Test
    public void dados_de_um_mapa() throws Exception {
        Map<String, String> testMap = Maps.newLinkedHashMap();
        testMap.put("Washington D.C", "Redskins");
        testMap.put("New York City", "Giants");
        testMap.put("Philadelphia", "Eagles");
        testMap.put("Dallas", "Cowboys");

        String returnedString = Joiner.on("#").
                withKeyValueSeparator("=").join(testMap);

        String citiesAndCapitals = "Washington D.C=Redskins#New York City=Giants#Philadelphia=Eagles#Dallas=Cowboys";
        assertThat(returnedString, is(citiesAndCapitals));

    }
}
