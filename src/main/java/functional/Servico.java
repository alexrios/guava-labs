package functional;

import com.google.common.collect.Sets;
import lombok.Data;

import java.util.Set;

@Data
public class Servico {
    private String codigo;
    private String nome;
    private Set<String> ddds = Sets.newHashSet();
}
