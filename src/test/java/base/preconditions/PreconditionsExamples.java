package base.preconditions;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

public class PreconditionsExamples {

    @Test(expected = IllegalStateException.class)
    public void condicao_de_estado() throws Exception {
        int idOperadora = 0;
        getOperadora(idOperadora);
    }

    public void getOperadora(int idOperadora) {
        Preconditions.checkState(idOperadora != 0, "Operadora com id zerado");
    }

    @Test(expected = NullPointerException.class)
    public void condicao_nula() throws Exception {
        imprimeJogadores(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void condicao_argumento() throws Exception {
        imprimeJogadores(ImmutableList.of("Alex, Rios"));
    }

    public void imprimeJogadores(List<String> times) {
        Preconditions.checkNotNull(times, "Valores nao podem ser nulos");
        Preconditions.checkArgument(times.size() == 11, "Time deve ter 11 jogadores");
    }


}
