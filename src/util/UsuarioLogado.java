/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import model.Usuario;

/**
 *
 * @author guilh
 */
public class UsuarioLogado {

    private static Usuario userLogado;

    public static Usuario getUserLogado() {
        return userLogado;
    }

    public static void setUserLogado(Usuario userLogado) {
        UsuarioLogado.userLogado = userLogado;
    }

}
