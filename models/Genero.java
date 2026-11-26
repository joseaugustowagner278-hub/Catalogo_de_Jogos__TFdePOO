
package models;

import java.io.Serializable;
import java.util.Objects;

public class Genero implements Serializable {
    // genêro do jogo (fps, sandbox, rpg, etc.)
    private static final long serialVersionUID = 1L;

    private String nome;

    public Genero(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Compara os gêneros pelo nome.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Genero outro = (Genero) obj;

        return Objects.equals(nome, outro.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "Genero{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
