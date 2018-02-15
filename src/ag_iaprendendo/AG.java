package ag_iaprendendo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AG {

    private List<CromossomoIAprendendo> populacao;
    private int questoes[];
    private char[] conceitoQuestao;
    char conceitoAluno;
    public CromossomoIAprendendo melhorDeTodos;

    private AG() {
        populacao = new ArrayList<CromossomoIAprendendo>();
        melhorDeTodos = new CromossomoIAprendendo();
    }

    public AG(int questoes[], char conceitoQuestao[], char conceitoAluno) {
        this();
        this.questoes = new int[questoes.length];
        this.conceitoQuestao = new char[conceitoQuestao.length];
        for (int i = 0; i < questoes.length; i++) {
            this.questoes[i] = questoes[i];
            this.conceitoQuestao[i] = conceitoQuestao[i];
        }
        this.conceitoAluno = conceitoAluno;
    }

    public void inicializaPopulacao(int tamanhoPopulacao) {
        this.populacao.clear();
        for (int i = 0; i < tamanhoPopulacao; i++) {
            this.populacao.add(new CromossomoIAprendendo(questoes, conceitoQuestao, conceitoAluno));
        }
    }

    private double somaAvaliacoes() {
        double retorno = 0;
        Iterator<CromossomoIAprendendo> it = this.populacao.iterator();
        while (it.hasNext()) {
            CromossomoIAprendendo prox = it.next();
            retorno += prox.avaliacao();
        }
        return (retorno);
    }

    private int selecionaPai(double somaAvaliacoes) {
        int retorno = -1;
        double valorSorteado = Math.random() * somaAvaliacoes;
        double soma = 0;
        Iterator<CromossomoIAprendendo> it = this.populacao.iterator();
        do {
            soma += it.next().avaliacao();
            retorno++;
        } while ((it.hasNext()) && (soma < valorSorteado));
        return (retorno);
    }

    public void run(double taxaMutacao, int numGeracoes, int tamanhoPopulacao) {
        CromossomoIAprendendo melhor;
        List<CromossomoIAprendendo> novaPopulacao = new ArrayList<CromossomoIAprendendo>();
        inicializaPopulacao(tamanhoPopulacao);
        for (int geracaoCorrente = 0; geracaoCorrente < numGeracoes; geracaoCorrente++) {
            double somaAvaliacoes = this.somaAvaliacoes();
            novaPopulacao.clear();
            for (int individuosGerados = 0; individuosGerados < tamanhoPopulacao; individuosGerados += 2) {
                int pai1 = this.selecionaPai(somaAvaliacoes);
                int pai2 = this.selecionaPai(somaAvaliacoes);
                CromossomoIAprendendo[] filhos = populacao.get(pai1).crossover(populacao.get(pai2));
                novaPopulacao.add(filhos[0].mutacao());
                novaPopulacao.add(filhos[1].mutacao());
            }
            //novaPopulacao.add(populacao.get(populacao.size()-1));
            populacao.clear();
            populacao.addAll(novaPopulacao);
            Collections.sort(populacao);
            melhor = populacao.get(populacao.size() - 1);
            System.out.println("Melhor da geracao #" + geracaoCorrente + " = " + melhor + " com avaliação " + melhor.avaliacao());
            if (geracaoCorrente == 0) {
                melhorDeTodos = melhor;
            } else if (melhorDeTodos.avaliacao() < melhor.avaliacao()) {
                melhorDeTodos = melhor;
            }
        }
    }
}
