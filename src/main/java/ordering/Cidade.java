package ordering;

import lombok.Data;

@Data
public class Cidade {
    private int populacao;
    private double imposto;

    public Cidade(int populacao, double imposto) {
        this.populacao = populacao;
        this.imposto = imposto;
    }
}
