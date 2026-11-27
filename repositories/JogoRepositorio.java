
package repositories;

import java.util.ArrayList;
import java.util.List;

import models.Jogo;

public class JogoRepositorio {
    // Gerencia a coleção de jogos: adicionar, listar, buscar e remover.
    private ArrayList<Jogo> jogos;

    public JogoRepositorio() {
        this.jogos = new ArrayList<>();
    }

    // Adiciona um jogo ao catálogo, impedindo valores nulos.
    public void adicionar(Jogo jogo) {
        if (jogo == null) {
            throw new IllegalArgumentException("O jogo não pode ser nulo.");
        }

        jogos.add(jogo);
    }

    // Retorna uma cópia da lista para proteger a coleção original.
    public List<Jogo> listarTodos() {
        return new ArrayList<>(jogos);
    }

    // Procura um jogo pelo nome, ignorando diferenças entre maiúsculas e
    // minúsculas.
    public Jogo buscarPorNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return null;
        }

        for (Jogo jogo : jogos) {
            if (jogo.getNome().equalsIgnoreCase(nome)) {
                return jogo;
            }
        }

        return null;
    }

    // Remove um jogo do catálogo e informa se a remoção foi realizada.
    public boolean remover(Jogo jogo) {
        return jogos.remove(jogo);
    }

    // Retorna a quantidade de jogos cadastrados.
    public int quantidade() {
        return jogos.size();
    }

    // Limpa todos os jogos armazenados no repositório.
    public void limpar() {
        jogos.clear();
    }
}
