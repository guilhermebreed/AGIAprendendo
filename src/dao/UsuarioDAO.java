/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

/**
 *
 * @author guilh
 */
public class UsuarioDAO implements Serializable {

    public boolean save(Usuario entidade) {
        Connection conn = Conexao.open();
        PreparedStatement pstm = null;
        String sql = "INSERT INTO usuario (conceito_usuario, usuario, senha) "
                + "VALUES (?, ?, ?)";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, entidade.getConceitoUsuario());
            pstm.setString(2, entidade.getUsuario());
            pstm.setString(3, entidade.getSenha());
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
        String sql = "SELECT MAX(idUsuario) FROM usuario";
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

    public Usuario findById(int id) {
        Connection conn = Conexao.open();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Usuario resposta = new Usuario();
        String sql = "SELECT * FROM usuario WHERE idUsuario = ?";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);

            rs = pstm.executeQuery();
            if (rs.next()) {
                resposta.setIdUsuario(rs.getInt("idUsuario"));
                resposta.setConceitoUsuario(rs.getString("conceito_usuario"));
                resposta.setUsuario(rs.getString("usuario"));
                resposta.setSenha(rs.getString("senha"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conn, pstm, rs);
        }
        return resposta;
    }

    public List<Usuario> findAll() {
        Connection conn = Conexao.open();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM usuario";
        List usuarioList = new ArrayList();
        Usuario usuario = null;
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setConceitoUsuario(rs.getString("conceito_usuario"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setSenha(rs.getString("senha"));
                usuarioList.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conn, pstm, rs);
        }
        return usuarioList;
    }

    public List<Usuario> findByConceitoUsuario(String conceitoUsuario) {
        Connection conn = Conexao.open();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql
                = "SELECT u.* FROM usuario u WHERE u.conceito_usuario = ? ";

        //System.out.println("Conceito usuario: " + conceitoUsuario);
        List usuarioList = new ArrayList();

        Usuario usuario = null;

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, conceitoUsuario);
            rs = pstm.executeQuery();
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setConceitoUsuario(rs.getString("conceito_usuario"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setSenha(rs.getString("senha"));
                usuarioList.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conn, pstm, rs);
        }
        return usuarioList;
    }

    public Usuario findByUsuario(String usuario) {
        Connection conn = Conexao.open();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql
                = "SELECT u.* FROM usuario u WHERE u.usuario = ? LIMIT 1";

        Usuario usuarioLogin = null;

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario);
            rs = pstm.executeQuery();
            if (rs.next()) {
                usuarioLogin = new Usuario();
                usuarioLogin.setIdUsuario(rs.getInt("idUsuario"));
                usuarioLogin.setConceitoUsuario(rs.getString("conceito_usuario"));
                usuarioLogin.setUsuario(rs.getString("usuario"));
                usuarioLogin.setSenha(rs.getString("senha"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conn, pstm, rs);
        }
        return usuarioLogin;
    }

}
