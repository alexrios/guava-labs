package base.strings;

import com.google.common.base.Strings;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StringsExamples {


    public static final int MIN_LENGTH = 6;

    @Test
    public void padEnd() throws Exception {
        String padded = Strings.padEnd("Alex", MIN_LENGTH, '0');
        assertThat(padded, is("Alex00"));
    }

    @Test
    public void padStart() throws Exception {
        String padded = Strings.padStart("Alex", MIN_LENGTH, '0');
        assertThat(padded, is("00Alex"));
    }

    @Test
    public void repeat() throws Exception {
        String repeated = Strings.repeat("Alex", 2);
        assertThat(repeated, is("AlexAlex"));
    }

    @Test
    public void commonPrefix() throws Exception {
        String prefix = Strings.commonPrefix("AlexRios", "AlexM4U");
        assertThat(prefix, is("Alex"));
    }

    @Test
    public void commonSuffix() throws Exception {
        String suffix = Strings.commonSuffix("AlexRiosM4U", "ZezinhoM4U");
        assertThat(suffix, is("M4U"));
    }

}
