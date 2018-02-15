/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author guilh
 */
public class Questao{

    private int idQuestao;
    private String questao;
    private String alt_1;
    private String alt_2;
    private String alt_3;
    private String alt_Certa;
    private String conceitoQuestao;

    private List<Prova> usuarios;

    public int getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(int idQuestao) {
        this.idQuestao = idQuestao;
    }

    public String getQuestao() {
        return questao;
    }

    public void setQuestao(String questao) {
        this.questao = questao;
    }

    public String getAlt_1() {
        return alt_1;
    }

    public void setAlt_1(String alt_1) {
        this.alt_1 = alt_1;
    }

    public String getAlt_2() {
        return alt_2;
    }

    public void setAlt_2(String alt_2) {
        this.alt_2 = alt_2;
    }

    public String getAlt_3() {
        return alt_3;
    }

    public void setAlt_3(String alt_3) {
        this.alt_3 = alt_3;
    }

    public String getAlt_Certa() {
        return alt_Certa;
    }

    public void setAlt_Certa(String alt_Certa) {
        this.alt_Certa = alt_Certa;
    }

    public String getConceitoQuestao() {
        return conceitoQuestao;
    }

    public void setConceitoQuestao(String conceitoQuestao) {
        this.conceitoQuestao = conceitoQuestao;
    }

    public List<Prova> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Prova> usuarios) {
        this.usuarios = usuarios;
    }

}
