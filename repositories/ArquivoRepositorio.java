
package repositories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import models.Jogo;

public class ArquivoRepositorio {

    // Grava a coleção completa de jogos em um arquivo binário.
    public void salvarJogos(List<Jogo> jogos, String caminho) throws IOException {

        try (ObjectOutputStream saida = new ObjectOutputStream(
                new FileOutputStream(caminho))) {

            saida.writeObject(new ArrayList<>(jogos));
        }
    }

    // Recupera os jogos armazenados no arquivo binário.
    public List<Jogo> carregarJogos(String caminho)
            throws IOException, ClassNotFoundException {

        try (ObjectInputStream entrada = new ObjectInputStream(
                new FileInputStream(caminho))) {

            Object objeto = entrada.readObject();

            if (!(objeto instanceof List<?>)) {
                throw new IOException("O arquivo não contém uma lista de jogos.");
            }

            List<?> lista = (List<?>) objeto;
            List<Jogo> jogos = new ArrayList<>();

            // Verifica se todos os elementos recuperados são objetos Jogo.
            for (Object item : lista) {
                if (!(item instanceof Jogo)) {
                    throw new IOException("O arquivo contém dados incompatíveis.");
                }

                jogos.add((Jogo) item);
            }

            return jogos;
        }
    }
}
