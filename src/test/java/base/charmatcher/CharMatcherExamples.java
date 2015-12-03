package base.charmatcher;

import com.google.common.base.CharMatcher;
import org.junit.Test;

import static java.lang.Boolean.TRUE;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CharMatcherExamples {

    @Test
    public void whitespace() throws Exception {
        String tabsAndSpaces = "String       with    spaces       and       tabs";
        String expected = "String with spaces and tabs";

        String fixedWhiteSpaces = CharMatcher.WHITESPACE.collapseFrom(tabsAndSpaces, ' ');
        assertThat(fixedWhiteSpaces, is(expected));
    }

    @Test
    public void substituindo() {
        String retained = CharMatcher.DIGIT.replaceFrom("foo989yxbar234", 'X');

        assertThat("fooXXXyxbarXXX", is(retained));
    }

    @Test
    public void retendo() {
        String retained = CharMatcher.DIGIT.retainFrom("foo989yxbar234");

        assertThat("989234", is(retained));
    }

    @Test
    public void nao_deve_fazer_matching() {
        assertThat(CharMatcher.noneOf("xZ").matchesAnyOf("anything"), is(TRUE));
    }

    @Test
    public void deve_fazer_mathing_completo() {
        assertThat(CharMatcher.ANY.matchesAllOf("anything"), is(TRUE));
    }

    @Test
    public void contando_matchings() {
        assertThat(CharMatcher.DIGIT.countIn("AlexM4U"), is(1));
    }

    @Test
    public void removendo_no_intervalo() {
        assertThat(CharMatcher.inRange('1', '3').removeFrom("78323271"), is("787"));
    }

    @Test
    public void removendo_no_intervalo_negando() {
        assertThat(CharMatcher.inRange('1', '3').negate().removeFrom("78323271"), is("32321"));
    }

    @Test
    public void trim() {
        assertThat(CharMatcher.is('|').trimFrom("||| Alex Rios | M4U ||"), is(" Alex Rios | M4U "));
        assertThat(CharMatcher.is('|').trimLeadingFrom("||| Alex Rios | M4U ||"), is(" Alex Rios | M4U ||"));
        assertThat(CharMatcher.is('|').trimAndCollapseFrom("||| Alex Rios | M4U ||", 'X'), is(" Alex Rios X M4U "));
    }

}
