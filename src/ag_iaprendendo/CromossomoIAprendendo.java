package ag_iaprendendo;

import java.lang.reflect.Array;

public class CromossomoIAprendendo implements Comparable<CromossomoIAprendendo> {

    private StringBuffer cromossomo;
    private double taxaMutacao;
    private int questoes[];
    private char[] conceitoQuestao;
    private char conceitoAluno;

    public CromossomoIAprendendo() {
        cromossomo = new StringBuffer("");
        taxaMutacao = 0.05;
    }

    public CromossomoIAprendendo(int questoes[], char conceitoQuestao[], char conceitoAluno) {
        this();
        this.questoes = new int[questoes.length];
        this.conceitoQuestao = new char[conceitoQuestao.length];
        for (int i = 0; i < questoes.length; i++) {
            this.questoes[i] = questoes[i];
            this.conceitoQuestao[i] = conceitoQuestao[i];
        }
        this.conceitoAluno = conceitoAluno;
        for (int i = 1; i <= questoes.length; i++) {
            double valor = Math.random();
            if (valor < 0.33) {
                cromossomo.append("A");
            } else if (valor < 0.66) {
                cromossomo.append("B");
            } else {
                cromossomo.append("C");
            }
        }
    }

    public CromossomoIAprendendo[] crossover(CromossomoIAprendendo outro) {
        Class c = this.getClass();
        CromossomoIAprendendo[] filhos = null;
        filhos = (CromossomoIAprendendo[]) Array.newInstance(c, 2);
        try {
            filhos[0] = (CromossomoIAprendendo) c.newInstance();
            filhos[1] = (CromossomoIAprendendo) c.newInstance();
            filhos[0].setQuestoes(questoes);
            filhos[0].setConceitoQuestao(conceitoQuestao);
            filhos[0].setTaxaMutacao(taxaMutacao);
            filhos[0].setConceitoAluno(conceitoAluno);
            filhos[1].setQuestoes(questoes);
            filhos[1].setConceitoQuestao(conceitoQuestao);
            filhos[1].setTaxaMutacao(taxaMutacao);
            filhos[1].setConceitoAluno(conceitoAluno);
            int posicaoCorte = (int) Math.round(Math.random() * this.cromossomo.length()) - 1;
            String stringFilho1 = outro.getCromossomo().substring(0, posicaoCorte + 1) + this.getCromossomo().substring(posicaoCorte + 1);
            String stringFilho2 = this.getCromossomo().substring(0, posicaoCorte + 1) + outro.getCromossomo().substring(posicaoCorte + 1);
            filhos[0].setCromossomo(new StringBuffer(stringFilho1));
            filhos[1].setCromossomo(new StringBuffer(stringFilho2));
        } catch (Exception ex) {
            System.out.println("Exceção: " + ex.getMessage());
            filhos = null;
        }
        return (filhos);
    }

    public CromossomoIAprendendo mutacao() {
        Class c = this.getClass();
        CromossomoIAprendendo filho = null;
        try {
            filho = (CromossomoIAprendendo) c.newInstance();
            StringBuffer resultado = new StringBuffer();
            for (int i = 0; i < this.cromossomo.length(); i++) {
                if (Math.random() < this.taxaMutacao) {
                    if (this.cromossomo.charAt(i) == 'A') {
                        resultado.append('A');
                    } else if (this.cromossomo.charAt(i) == 'B') {
                        resultado.append('B');
                    } else {
                        resultado.append("C");
                    }
                } else {
                    resultado.append(this.cromossomo.charAt(i));
                }
            }
            filho.setCromossomo(new StringBuffer(resultado));
            filho.setQuestoes(questoes);
            filho.setConceitoQuestao(conceitoQuestao);
            filho.setTaxaMutacao(taxaMutacao);
            filho.setConceitoAluno(conceitoAluno);

        } catch (Exception ex) {
            filho = null;
        }
        return (filho);
    }

    //Avalia se o conceito do aluno é igual ao conceito da questão e retorna um valor;
    public double avaliacao() {
        double somaGene = 0;
        String crom = this.getCromossomo().toString().toUpperCase();
        for (int i = 0; i < crom.length(); i++) {

            if (this.conceitoAluno == 'C') {
                if (crom.charAt(i) == 'A') {
                    somaGene++;
                } else if (crom.charAt(i) == 'B') {
                    somaGene += 2;
                } else if (crom.charAt(i) == 'C') {
                    somaGene += 3;
                }
            }
            if (this.conceitoAluno == 'B') {
                if (crom.charAt(i) == 'A') {
                    somaGene += 2;
                } else if (crom.charAt(i) == 'B') {
                    somaGene += 3;
                } else if (crom.charAt(i) == 'C') {
                    somaGene++;
                }
            }
            if (this.conceitoAluno == 'A') {
                if (crom.charAt(i) == 'A') {
                    somaGene += 3;
                } else if (crom.charAt(i) == 'B') {
                    somaGene += 2;
                } else if (crom.charAt(i) == 'C') {
                    somaGene++;
                }
            }
        }
        return somaGene;
    }

    public StringBuffer getCromossomo() {
        return cromossomo;
    }

    public void setCromossomo(StringBuffer cromossomo) {
        this.cromossomo = cromossomo;
    }

    public String toString() {
        return (this.cromossomo.toString());
    }

    /**
     * @return the taxaMutacao
     */
    public double getTaxaMutacao() {
        return taxaMutacao;
    }

    /**
     * @param taxaMutacao the taxaMutacao to set
     */
    public void setTaxaMutacao(double taxaMutacao) {
        this.taxaMutacao = taxaMutacao;
    }

    public int[] getQuestoes() {
        return questoes;
    }

    /**
     * @param questoes the questoes to set
     */
    public void setQuestoes(int[] pesos) {
        this.questoes = questoes;
    }

    /**
     * @return the conceitoQuestao
     */
    public char[] getConceitoQuestao() {
        return conceitoQuestao;
    }

    public void setConceitoQuestao(char[] conceitoQuestao) {
        this.conceitoQuestao = conceitoQuestao;
    }

    @Override
    public boolean equals(Object outro) {
        if (!this.getClass().equals(outro.getClass())) {
            return false;
        }
        return (this.getCromossomo().equals((CromossomoIAprendendo) outro));
    }

    public int compareTo(CromossomoIAprendendo outro) {
        return ((new Double(this.avaliacao())).compareTo(outro.avaliacao()));
    }

    /**
     * @return the conceitoAluno
     */
    public char getConceitoAluno() {
        return conceitoAluno;
    }

    /**
     * @param conceitoAluno the conceitoAluno to set
     */
    public void setConceitoAluno(char conceitoAluno) {
        this.conceitoAluno = conceitoAluno;
    }

}
