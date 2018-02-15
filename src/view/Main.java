/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ag_iaprendendo.AG;
import dao.ProvaDAO;
import dao.QuestaoDAO;
import dao.UsuarioDAO;
import javax.swing.JOptionPane;
import model.Prova;
import model.Questao;
import model.Usuario;
import util.UsuarioLogado;

/**
 *
 * @author guilh
 */
public class Main {
    
    public static void main(String[] args) {
        
        UsuarioDAO uD = new UsuarioDAO();
        Usuario u = new Usuario();
//
//        u.setIdUsuario(1);
//        u.setUsuario("Igor");
//        u.setSenha("1234");
//        u.setConceitoUsuario("C");
//
//        if (uD.save(u)) {
//            System.out.println("Salvo com sucesso!!!");
//        } else {
//            System.out.println("Erro ao salvar!!!");
//        }
        //------------------------------------\\
        QuestaoDAO qD = new QuestaoDAO();
        Questao q = new Questao();
//
//        q.setIdQuestao(1);
//        q.setQuestao(" Uma prefeitura aplicou R$ 850 mil na construção "
//                + "de 3 creches e um parque infantil. O custo de "
//                + "cada creche foi de R$ 250 mil. A expressão que "
//                + "representa o custo do parque, em mil reais, é ");
//        q.setAlt_Certa("850 = x + 750.  ");
//        q.setAlt_1("850 = x + 250. ");
//        q.setAlt_2("x – 850 = 750. ");
//        q.setAlt_3("x + 850 = 250. ");
//        q.setConceitoQuestao("A");
//
//        if (qD.save(q)) {
//            System.out.println("Salvo com sucesso!!!");
//        } else {
//            System.out.println("Erro ao salvar!!!");
//        }
        //------------------------------------\\
//        ProvaDAO pD = new ProvaDAO();
//        Prova p = new Prova();
//
//        p.setQuestao(q);
//        p.setUsuario(u);
//        p.setResposta("c");

//        if(pD.save(p)){
//            System.out.println("Salvo com sucesso!!!");
//        }else{
//            System.out.println("Erro ao salvar!!!");
//        }
        //Questoes
//        for (Questao questao : qD.findAll()) {
//            System.out.println("Questao: " + questao.getIdQuestao() + "\n"
//                    + "Conceito: " + questao.getConceitoQuestao() + "\n"
//                    + questao.getQuestao() + "\n"
//                    + "A) " + questao.getAlt_1() + "\n"
//                    + "B) " + questao.getAlt_2() + "\n"
//                    + "C) " + questao.getAlt_3() + "\n"
//                    + "D) " + questao.getAlt_Certa());
//        }
//
//        //Provas
//        for (Prova prova : pD.findAll()) {
//            System.out.println("Prova: " + prova.getIdProva() + "\n"
//                    + "Questao: " + prova.getQuestao().getIdQuestao() + "\n"
//                    + "Usuario: " + prova.getUsuario().getIdUsuario() + "\n"
//                    + "Resposta: " + prova.getResposta() + "\n"
//            );
//        }
//        
//        
//        if (p.getResposta() == q.getAlt_Certa()){
//            System.out.println("Resposta correta");
//            p.setResposta("c");
//        }else{
//            System.out.println("Respsta incorreta");
//            p.setResposta("e");
//        }
//        
//        System.out.println("Resposta: " + p.getResposta());
//
//        
//        for (Questao questao : qD.findByConceitoNaoFeita(UsuarioLogado.getUserLogado().getConceitoUsuario(), 2)){
//            System.out.println("Questao: " + questao.getQuestao());
//        }
//        
//   
        String usuario, senha;
        usuario = JOptionPane.showInputDialog("Informe o usuario: ");
        senha = JOptionPane.showInputDialog("Informe a senha: ");
        Usuario uTentativa = uD.findByUsuario(usuario);
        if (uTentativa != null) {
            if (uTentativa.getUsuario().equals(usuario) && uTentativa.getSenha().equals(senha)) {
                JOptionPane.showMessageDialog(null, "Login realizado com Sucesso!!");
                UsuarioLogado.setUserLogado(uTentativa);
                
                formProva fP = new formProva();
                fP.setVisible(true);
                System.out.println(UsuarioLogado.getUserLogado().getUsuario());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Erro: usuario ou senha invalidos");
        }
    }
}
