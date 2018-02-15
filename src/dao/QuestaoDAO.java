/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Questao;
import model.Usuario;
import util.UsuarioLogado;

/**
 *
 * @author guilh
 */
public class QuestaoDAO implements Serializable {

    public boolean save(Questao entidade) {
        Connection conn = Conexao.open();
        PreparedStatement pstm = null;
        String sql = "INSERT INTO questao (questao, alt_1, alt_2, alt_3, alt_certa, conceito_questao) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, entidade.getQuestao());
            pstm.setString(2, entidade.getAlt_1());
            pstm.setString(3, entidade.getAlt_2());
            pstm.setString(4, entidade.getAlt_3());
            pstm.setString(5, entidade.getAlt_Certa());
            pstm.setString(6, entidade.getConceitoQuestao());
            pstm.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            Conexao.close(conn, pstm, null);
        }
    }

    public int findMaxId() {
        Connection conn = Conexao.open();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT MAX(idQuestao) FROM questao";
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

    public Questao findById(int id) {
        Connection conn = Conexao.open();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Questao resposta = new Questao();
        String sql = "SELECT * FROM questao WHERE idQuestao = ?";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);

            rs = pstm.executeQuery();
            if (rs.next()) {
                resposta.setIdQuestao(rs.getInt("idQuestao"));
                resposta.setQuestao(rs.getString("questao"));
                resposta.setConceitoQuestao(rs.getString("conceito_questao"));
                resposta.setAlt_1(rs.getString("alt_1"));
                resposta.setAlt_2(rs.getString("alt_2"));
                resposta.setAlt_3(rs.getString("alt_3"));
                resposta.setAlt_Certa(rs.getString("alt_certa"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conn, pstm, rs);
        }
        return resposta;
    }

    public List<Questao> findAll() {
        Connection conn = Conexao.open();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM questao";
        List questaoList = new ArrayList();
        Questao questao = null;
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                questao = new Questao();
                questao.setIdQuestao(rs.getInt("idQuestao"));
                questao.setQuestao(rs.getString("questao"));
                questao.setAlt_1(rs.getString("alt_1"));
                questao.setAlt_2(rs.getString("alt_2"));
                questao.setAlt_3(rs.getString("alt_3"));
                questao.setAlt_Certa(rs.getString("alt_certa"));
                questao.setConceitoQuestao(rs.getString("conceito_questao"));
                questaoList.add(questao);

//                System.out.println("Questao: " + questao.getIdQuestao() + "\n"
//                        + questao.getQuestao() + "\n"
//                        + questao.getConceitoQuestao() + "\n"
//                        + questao.getAlt_1() + "\n"
//                        + questao.getAlt_2() + "\n"
//                        + questao.getAlt_3() + "\n"
//                        + questao.getAlt_Certa());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conn, pstm, rs);
        }
        return questaoList;
    }

    public List<Questao> findByConceitoQuestao(String conceitoQuestao) {
        Connection conn = Conexao.open();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql
                = "SELECT q.* FROM questao q WHERE q.conceito_questao = ? ";

        List<Questao> questaoList = new ArrayList();

        Questao questao = null;

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, conceitoQuestao);
            rs = pstm.executeQuery();
            while (rs.next()) {
                questao = new Questao();
                questao.setIdQuestao(rs.getInt("idQuestao"));
                questao.setQuestao(rs.getString("questao"));
                questao.setAlt_1(rs.getString("alt_1"));
                questao.setAlt_2(rs.getString("alt_2"));
                questao.setAlt_3(rs.getString("alt_3"));
                questao.setAlt_Certa(rs.getString("alt_certa"));
                questao.setConceitoQuestao(rs.getString("conceito_questao"));
                questaoList.add(questao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conn, pstm, rs);
        }
        return questaoList;
    }

    public List<Questao> findByConceitoNaoFeita(String conceitoQuestao, int qtdQuestao) {
        Connection conn = Conexao.open();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql
                = "SELECT q.* FROM questao q left join prova p on "
                + "p.IdQuestao = q.IdQuestao "
                + "where (idProva is null or not (IdUsuario = ?) or p.Resposta LIKE \"e\") and conceito_questao LIKE ? "+
                " LIMIT " + qtdQuestao;

        List<Questao> questaoList = new ArrayList();

        Questao questao = null;

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, UsuarioLogado.getUserLogado().getIdUsuario());
            pstm.setString(2, UsuarioLogado.getUserLogado().getConceitoUsuario());
            rs = pstm.executeQuery();
            while (rs.next()) {
                questao = new Questao();
                questao.setIdQuestao(rs.getInt("idQuestao"));
                questao.setQuestao(rs.getString("questao"));
                questao.setAlt_1(rs.getString("alt_1"));
                questao.setAlt_2(rs.getString("alt_2"));
                questao.setAlt_3(rs.getString("alt_3"));
                questao.setAlt_Certa(rs.getString("alt_certa"));
                questao.setConceitoQuestao(rs.getString("conceito_questao"));
                questaoList.add(questao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conn, pstm, rs);
        }
        return questaoList;
    }

    public List<Questao> findByUsuario(String usuario) {
        Connection conn = Conexao.open();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql
                = "SELECT u.* FROM usuario u WHERE u.usuario = ? ";

        List usuarioList = new ArrayList();

        Usuario usuarioLogin = null;

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario);
            rs = pstm.executeQuery();
            while (rs.next()) {
                usuarioLogin = new Usuario();
                usuarioLogin.setIdUsuario(rs.getInt("idUsuario"));
                usuarioLogin.setConceitoUsuario(rs.getString("conceito_usuario"));
                usuarioLogin.setUsuario(rs.getString("usuario"));
                usuarioLogin.setSenha(rs.getString("senha"));
                usuarioList.add(usuarioLogin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conn, pstm, rs);
        }
        return usuarioList;
    }

}
