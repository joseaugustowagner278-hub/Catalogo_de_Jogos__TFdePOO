
package models;

import java.io.Serializable;
import java.util.Objects;

public class Plataforma implements Serializable {
    // plataforma ao qual o jogo está disponível.
    private static final long serialVersionUID = 1L;

    private String nome;

    public Plataforma(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Compara duas plataformas pelo nome.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Plataforma outra = (Plataforma) obj;

        return Objects.equals(nome, outra.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "Plataforma{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
