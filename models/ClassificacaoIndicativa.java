
package models;

import java.io.Serializable;
import java.util.Objects;

public class ClassificacaoIndicativa implements Serializable {
    // informações das classificações indicativas dos jogos (livre, +10, +14, +16,
    // +18)
    private static final long serialVersionUID = 1L;

    private String classificacao;

    public ClassificacaoIndicativa(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    // Compara classificações pelo seu valor.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        ClassificacaoIndicativa outra = (ClassificacaoIndicativa) obj;

        return Objects.equals(classificacao, outra.classificacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classificacao);
    }

    @Override
    public String toString() {
        return "ClassificacaoIndicativa{" +
                "classificacao='" + classificacao + '\'' +
                '}';
    }
}
