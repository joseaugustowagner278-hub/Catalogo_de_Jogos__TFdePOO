
package models;

public class JogoDigital extends Jogo {
 // jogos de mídia digital, tanto para PC, mobile e console.F
    public JogoDigital(String nome, String generoPrincipal, Double avaliacao,
                       Integer quantidadeAvaliacoes, Integer anoLancamento,
                       Double notaMetacritic, Integer tempoJogo,
                       Integer quantidadeGeneros, String tipoJogo,
                       Integer quantidadePlataformas, Boolean disponivelPC,
                       Boolean disponivelConsole, Boolean disponivelMobile,
                       String classificacaoIndicativa) {

        super(nome, generoPrincipal, avaliacao, quantidadeAvaliacoes,
                anoLancamento, notaMetacritic, tempoJogo,
                quantidadeGeneros, tipoJogo, quantidadePlataformas,
                disponivelPC, disponivelConsole, disponivelMobile,
                classificacaoIndicativa);
    }

    // Retorna as plataformas digitais disponíveis para o jogo.
    @Override
    public String getDescricaoDisponibilidade() {
        StringBuilder descricao = new StringBuilder();

        if (Boolean.TRUE.equals(getDisponivelPC())) {
            descricao.append("PC");
        }

        if (Boolean.TRUE.equals(getDisponivelMobile())) {
            if (descricao.length() > 0) {
                descricao.append(", ");
            }
            descricao.append("Mobile");
        }

        if (descricao.length() == 0) {
            return "Nenhuma plataforma digital disponível";
        }

        return descricao.toString();
    }
}
