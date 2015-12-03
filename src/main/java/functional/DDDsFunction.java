package functional;

import com.google.common.base.Function;
import com.google.common.base.Joiner;

public class DDDsFunction implements Function<Servico, String> {
    public String apply(Servico servico) {
        return Joiner.on(";").join(servico.getDdds());
    }
}
