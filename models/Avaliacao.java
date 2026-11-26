
package models;

import java.io.Serializable;
import java.util.Objects;

public class Avaliacao implements Serializable {
    // avaliação dos jogos
    private static final long serialVersionUID = 1L;

    private Double nota;
    private Integer quantidadeAvaliacoes;

    public Avaliacao(Double nota, Integer quantidadeAvaliacoes) {
        this.nota = nota;
        this.quantidadeAvaliacoes = quantidadeAvaliacoes;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Integer getQuantidadeAvaliacoes() {
        return quantidadeAvaliacoes;
    }

    public void setQuantidadeAvaliacoes(Integer quantidadeAvaliacoes) {
        this.quantidadeAvaliacoes = quantidadeAvaliacoes;
    }

    // Compara avaliações pela nota e quantidade de avaliações.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Avaliacao outra = (Avaliacao) obj;

        return Objects.equals(nota, outra.nota)
                && Objects.equals(quantidadeAvaliacoes, outra.quantidadeAvaliacoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nota, quantidadeAvaliacoes);
    }

    @Override
    public String toString() {
        return "Avaliacao{" +
                "nota=" + nota +
                ", quantidadeAvaliacoes=" + quantidadeAvaliacoes +
                '}';
    }
}
