package collections;

import com.google.common.collect.HashBasedTable;
import org.junit.Test;

import static java.lang.Boolean.TRUE;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TableExample {

    @Test
    public void table() throws Exception {
        HashBasedTable<Integer, Integer, String> table = HashBasedTable.create();
        table.put(1, 1, "Rook");
        table.put(1, 2, "Knight");
        table.put(1, 3, "Bishop");
        table.put(2, 1, "Queen");

        assertThat(table.contains(1, 1), is(TRUE));
        assertThat(table.containsColumn(2), is(TRUE));
        assertThat(table.containsRow(1), is(TRUE));
        assertThat(table.containsValue("Rook"), is(TRUE));

        assertThat(table.column(1).get(1), is("Rook"));
        assertThat(table.row(2).get(1), is("Queen"));

        assertThat(table.get(1, 1), is("Rook"));
    }
}
