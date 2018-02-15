/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import model.Prova;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Questao;
import model.Usuario;

/**
 *
 * @author guilh
 */
public class ProvaDAO implements Serializable{

    public boolean save(Prova entidade) {
        Connection conn = Conexao.open();
        PreparedStatement pstm = null;
        //System.out.println("id: " + entidade.getQuestao().getIdQuestao());
        //System.out.println("id: " + entidade.getUsuario().getIdUsuario());
        String sql
                = "INSERT INTO prova(idQuestao, idUsuario, resposta)"
                + " VALUES (?,?,?)";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, entidade.getQuestao().getIdQuestao());
            pstm.setInt(2, entidade.getUsuario().getIdUsuario());
            pstm.setString(3, entidade.getResposta());
            pstm.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            Conexao.close(conn, pstm, null);
        }
    }

    public Prova findById(int id) {
        Connection conn = Conexao.open();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM prova WHERE idProva = ?";
        Prova resposta = new Prova();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            
            rs = pstm.executeQuery();
            if (rs.next()) {
                resposta = rs.getObject(1, Prova.class);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conn, pstm, rs);
        }
        return resposta;
    }
    
    public int findMaxId() {
        Connection conn = Conexao.open();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT MAX(idProva) FROM prova";
        int id = 0;
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conn, pstm, rs);
        }
        return id;
    }
    
    public List<Prova> findAll() {
        Connection conn = Conexao.open();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM prova";
        List provaList = new ArrayList();
        Prova prova = null;
        QuestaoDAO qD = new QuestaoDAO();
        UsuarioDAO uD = new UsuarioDAO();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                prova = new Prova();
                prova.setIdProva(rs.getInt("idProva"));
                prova.setQuestao(qD.findById(rs.getInt("idQuestao")));
                prova.setUsuario(uD.findById(rs.getInt("idUsuario")));
                prova.setResposta(rs.getString("resposta"));
                provaList.add(prova);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conn, pstm, rs);
        }
        return provaList;
    }
}
