package functional;


import lombok.Data;

@Data
public class Recarga {
    private int valor;
    private StatusRecarga status;

    public Recarga(int valor) {
        this.valor = valor;
    }

    public StatusRecarga getStatus() {
        return status;
    }
}
