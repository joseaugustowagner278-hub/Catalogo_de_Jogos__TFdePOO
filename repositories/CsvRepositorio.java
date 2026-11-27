
package repositories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.Jogo;
import models.JogoConsole;
import models.JogoDigital;

public class CsvRepositorio {

    // Lê o CSV e transforma cada registro em um objeto Jogo.
    public List<Jogo> carregarJogos(String caminho) throws IOException {
        List<Jogo> jogos = new ArrayList<>();

        try (BufferedReader leitor = new BufferedReader(new FileReader(caminho))) {

            String linha;
            boolean primeiraLinha = true;

            while ((linha = leitor.readLine()) != null) {

                // Ignora o cabeçalho do arquivo.
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }

                if (linha.trim().isEmpty()) {
                    continue;
                }

                String[] dados = separarColunas(linha);

                if (dados.length != 14) {
                    System.out.println("Registro ignorado: quantidade de colunas inválida.");
                    continue;
                }

                try {
                    Jogo jogo = converterParaJogo(dados);
                    jogos.add(jogo);

                } catch (NumberFormatException e) {
                    System.out.println("Registro ignorado: valor numérico inválido.");
                }
            }
        }

        return jogos;
    }

    // Converte os valores do CSV para os tipos utilizados pelas classes Java.
    private Jogo converterParaJogo(String[] dados) {

        String nome = obterTexto(dados[0]);
        String genero = obterTexto(dados[1]);
        Double avaliacao = obterDouble(dados[2]);
        Integer quantidadeAvaliacoes = obterInteiro(dados[3]);
        Integer anoLancamento = obterInteiro(dados[4]);
        Double notaMetacritic = obterDouble(dados[5]);
        Integer tempoJogo = obterInteiro(dados[6]);
        Integer quantidadeGeneros = obterInteiro(dados[7]);
        String tipoJogo = obterTexto(dados[8]);
        Integer quantidadePlataformas = obterInteiro(dados[9]);
        Boolean disponivelPC = obterBoolean(dados[10]);
        Boolean disponivelConsole = obterBoolean(dados[11]);
        Boolean disponivelMobile = obterBoolean(dados[12]);
        String classificacao = obterTexto(dados[13]);

        // Escolhe a subclasse conforme a disponibilidade para consoles.
        if (Boolean.TRUE.equals(disponivelConsole)) {
            return new JogoConsole(
                    nome, genero, avaliacao, quantidadeAvaliacoes,
                    anoLancamento, notaMetacritic, tempoJogo,
                    quantidadeGeneros, tipoJogo, quantidadePlataformas,
                    disponivelPC, disponivelConsole, disponivelMobile,
                    classificacao);
        }

        return new JogoDigital(
                nome, genero, avaliacao, quantidadeAvaliacoes,
                anoLancamento, notaMetacritic, tempoJogo,
                quantidadeGeneros, tipoJogo, quantidadePlataformas,
                disponivelPC, disponivelConsole, disponivelMobile,
                classificacao);
    }

    // Trata campos vazios e valores nulos do CSV.
    private String obterTexto(String valor) {
        if (valor == null || valor.trim().isEmpty()
                || valor.trim().equalsIgnoreCase("None")) {
            return null;
        }

        return valor.trim();
    }

    private Integer obterInteiro(String valor) {
        String texto = obterTexto(valor);
        return texto == null ? null : Integer.valueOf(texto);
    }

    private Double obterDouble(String valor) {
        String texto = obterTexto(valor);
        return texto == null ? null : Double.valueOf(texto);
    }

    private Boolean obterBoolean(String valor) {
        String texto = obterTexto(valor);

        if (texto == null) {
            return null;
        }

        return Boolean.valueOf(texto);
    }

    // Separa as colunas respeitando campos entre aspas.
    private String[] separarColunas(String linha) {
        List<String> colunas = new ArrayList<>();
        StringBuilder valor = new StringBuilder();
        boolean entreAspas = false;

        for (int i = 0; i < linha.length(); i++) {
            char caractere = linha.charAt(i);

            if (caractere == '"') {
                if (entreAspas && i + 1 < linha.length()
                        && linha.charAt(i + 1) == '"') {
                    valor.append('"');
                    i++;
                } else {
                    entreAspas = !entreAspas;
                }
            } else if (caractere == ',' && !entreAspas) {
                colunas.add(valor.toString());
                valor.setLength(0);
            } else {
                valor.append(caractere);
            }
        }

        colunas.add(valor.toString());

        return colunas.toArray(new String[0]);
    }
}