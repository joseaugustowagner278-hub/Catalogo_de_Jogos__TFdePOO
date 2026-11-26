
package models;

import java.io.Serializable;
import java.util.Objects;

public class TipoJogo implements Serializable {
    // tipo ao qual o jogo pode ser jogado (online, offline, ambos)
    private static final long serialVersionUID = 1L;

    private String tipo;

    public TipoJogo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Compara os tipos de jogo pelo nome.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        TipoJogo outro = (TipoJogo) obj;

        return Objects.equals(tipo, outro.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo);
    }

    @Override
    public String toString() {
        return "TipoJogo{" +
                "tipo='" + tipo + '\'' +
                '}';
    }
}
