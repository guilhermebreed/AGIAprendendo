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
public class Usuario {

    private int idUsuario;
    private String conceitoUsuario;
    private String usuario;
    private String senha;

    private List<Prova> questoes;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getConceitoUsuario() {
        return conceitoUsuario;
    }

    public void setConceitoUsuario(String conceitoUsuario) {
        this.conceitoUsuario = conceitoUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Prova> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Prova> questoes) {
        this.questoes = questoes;
    }

}
