// imformações gerais do jogo
package models;

import java.io.Serializable;
import java.util.Objects;

// Classe base para os diferentes tipos de jogos do catálogo.
public abstract class Jogo implements Serializable {

    private static final long serialVersionUID = 1L;

    // Informações principais do jogo.
    private String nome;
    private String generoPrincipal;
    private Double avaliacao;
    private Integer quantidadeAvaliacoes;
    private Integer anoLancamento;
    private Double notaMetacritic;
    private Integer tempoJogo;
    private Integer quantidadeGeneros;
    private String tipoJogo;
    private Integer quantidadePlataformas;

    // Plataformas em que o jogo está disponível.
    private Boolean disponivelPC;
    private Boolean disponivelConsole;
    private Boolean disponivelMobile;

    private String classificacaoIndicativa;

    public Jogo(String nome, String generoPrincipal, Double avaliacao,
            Integer quantidadeAvaliacoes, Integer anoLancamento,
            Double notaMetacritic, Integer tempoJogo,
            Integer quantidadeGeneros, String tipoJogo,
            Integer quantidadePlataformas, Boolean disponivelPC,
            Boolean disponivelConsole, Boolean disponivelMobile,
            String classificacaoIndicativa) {

        this.nome = nome;
        this.generoPrincipal = generoPrincipal;
        this.avaliacao = avaliacao;
        this.quantidadeAvaliacoes = quantidadeAvaliacoes;
        this.anoLancamento = anoLancamento;
        this.notaMetacritic = notaMetacritic;
        this.tempoJogo = tempoJogo;
        this.quantidadeGeneros = quantidadeGeneros;
        this.tipoJogo = tipoJogo;
        this.quantidadePlataformas = quantidadePlataformas;
        this.disponivelPC = disponivelPC;
        this.disponivelConsole = disponivelConsole;
        this.disponivelMobile = disponivelMobile;
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    // Getters e setters para acessar e modificar os atributos.

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGeneroPrincipal() {
        return generoPrincipal;
    }

    public void setGeneroPrincipal(String generoPrincipal) {
        this.generoPrincipal = generoPrincipal;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Integer getQuantidadeAvaliacoes() {
        return quantidadeAvaliacoes;
    }

    public void setQuantidadeAvaliacoes(Integer quantidadeAvaliacoes) {
        this.quantidadeAvaliacoes = quantidadeAvaliacoes;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Double getNotaMetacritic() {
        return notaMetacritic;
    }

    public void setNotaMetacritic(Double notaMetacritic) {
        this.notaMetacritic = notaMetacritic;
    }

    public Integer getTempoJogo() {
        return tempoJogo;
    }

    public void setTempoJogo(Integer tempoJogo) {
        this.tempoJogo = tempoJogo;
    }

    public Integer getQuantidadeGeneros() {
        return quantidadeGeneros;
    }

    public void setQuantidadeGeneros(Integer quantidadeGeneros) {
        this.quantidadeGeneros = quantidadeGeneros;
    }

    public String getTipoJogo() {
        return tipoJogo;
    }

    public void setTipoJogo(String tipoJogo) {
        this.tipoJogo = tipoJogo;
    }

    public Integer getQuantidadePlataformas() {
        return quantidadePlataformas;
    }

    public void setQuantidadePlataformas(Integer quantidadePlataformas) {
        this.quantidadePlataformas = quantidadePlataformas;
    }

    public Boolean getDisponivelPC() {
        return disponivelPC;
    }

    public void setDisponivelPC(Boolean disponivelPC) {
        this.disponivelPC = disponivelPC;
    }

    public Boolean getDisponivelConsole() {
        return disponivelConsole;
    }

    public void setDisponivelConsole(Boolean disponivelConsole) {
        this.disponivelConsole = disponivelConsole;
    }

    public Boolean getDisponivelMobile() {
        return disponivelMobile;
    }

    public void setDisponivelMobile(Boolean disponivelMobile) {
        this.disponivelMobile = disponivelMobile;
    }

    public String getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(String classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    // Cada tipo de jogo deverá apresentar sua própria descrição.
    public abstract String getDescricaoDisponibilidade();

    // Compara dois jogos pelo nome e ano de lançamento.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Jogo outro = (Jogo) obj;

        return Objects.equals(nome, outro.nome)
                && Objects.equals(anoLancamento, outro.anoLancamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, anoLancamento);
    }

    // Retorna as principais informações do jogo em formato de texto.
    @Override
    public String toString() {
        return "Jogo{" +
                "nome='" + nome + '\'' +
                ", generoPrincipal='" + generoPrincipal + '\'' +
                ", avaliacao=" + avaliacao +
                ", anoLancamento=" + anoLancamento +
                ", tipoJogo='" + tipoJogo + '\'' +
                ", classificacaoIndicativa='" + classificacaoIndicativa + '\'' +
                '}';
    }
}
