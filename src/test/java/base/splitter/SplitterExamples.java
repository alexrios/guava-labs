package base.splitter;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SplitterExamples {
    //TODO: Matcher de listas

    @Test
    public void usando_splitter() throws Exception {
        List<String> strings = Splitter.on('|').splitToList("foo|bar|baz");

        assertThat(strings, Is.<List<String>>is(ImmutableList.of("foo", "bar", "baz")));
    }

    @Test
    public void usando_trim() throws Exception {
        List<String> strings = Splitter.on('|')
                .trimResults()
                .splitToList("foo|bar||baz|");

        assertThat(strings, Is.<List<String>>is(ImmutableList.of("foo", "bar", "", "baz", "")));
    }

    @Test
    public void evitando_strings_vazias() throws Exception {
        List<String> strings = Splitter.on('|').omitEmptyStrings()
                .trimResults()
                .splitToList("foo|bar||baz|");

        assertThat(strings, Is.<List<String>>is(ImmutableList.of("foo", "bar", "baz")));
    }

    @Test
    public void separando_mapas() throws Exception {
        String startString = "Washington D.C=Redskins#New York City=Giants#Philadelphia=Eagles#Dallas=Cowboys";
        Map<String, String> testMap = Maps.newLinkedHashMap();
        testMap.put("Washington D.C", "Redskins");
        testMap.put("New York City", "Giants");
        testMap.put("Philadelphia", "Eagles");
        testMap.put("Dallas", "Cowboys");
        Splitter.MapSplitter mapSplitter =
                Splitter.on("#").withKeyValueSeparator("=");
        Map<String, String> splitMap = mapSplitter.split(startString);

        assertThat(testMap, is((splitMap)));
    }
}
