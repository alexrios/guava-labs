package collections;

import lombok.Data;

@Data
public class Pessoa {
    private String nome;
    private String sobrenome;
    private int idade;
    private String sexo;


    public Pessoa(String nome, String sobrenome, int idade, String sexo) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.sexo = sexo;
    }
}
