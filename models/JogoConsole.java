
package models;

public class JogoConsole extends Jogo {
    // o jogo possui mídia física
    
    public JogoConsole(String nome, String generoPrincipal, Double avaliacao,
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

    // Retorna se o jogo possui disponibilidade para consoles.
    @Override
    public String getDescricaoDisponibilidade() {

        if (Boolean.TRUE.equals(getDisponivelConsole())) {
            return "Disponível para consoles";
        }

        return "Não disponível para consoles";
    }
}
