package base.joiner;

import base.joiner.LegacyJoiner;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JoinerVersions {

    private ImmutableList<String> nomes;
    private LegacyJoiner legacyJoiner;

    @Before
    public void setUp() throws Exception {
        nomes = ImmutableList.of("Alex", "Rios", "M4U");
        legacyJoiner = new LegacyJoiner();
    }

    @Test
    public void usando_legacy_joiner() throws Exception {
        String csv = legacyJoiner.buildString(nomes, ";");

        assertThat(csv, is("Alex;Rios;M4U"));
    }

    @Test
    public void usando_guava_joiner() throws Exception {
        String csv = Joiner.on(";").join(nomes);

        assertThat(csv, is("Alex;Rios;M4U"));
    }

    @Test
    public void usando_java8_joiner() throws Exception {
        String csv = String.join(";", nomes);

        assertThat(csv, is("Alex;Rios;M4U"));
    }

}
