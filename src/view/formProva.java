/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ag_iaprendendo.AG;
import dao.ProvaDAO;
import dao.QuestaoDAO;
import dao.UsuarioDAO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import model.Prova;
import model.Questao;
import model.Usuario;
import util.UsuarioLogado;

/**
 *
 * @author italoandrade
 */
public class formProva extends javax.swing.JFrame {

    /**
     * Creates new form formProva
     */
    public formProva() {

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gpRbRespostas = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnProva = new javax.swing.JPanel();
        lblProvaQuestao = new javax.swing.JLabel();
        lblPlacarResultado = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtProvaQuestao = new javax.swing.JTextArea();
        btnIniciar = new javax.swing.JButton();
        btnResponder = new javax.swing.JButton();
        rbAlternativaA = new javax.swing.JRadioButton();
        rbAlternativaB = new javax.swing.JRadioButton();
        rbAlternativaC = new javax.swing.JRadioButton();
        rbAlternativaD = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblProvaQuestao.setText("Questao x");

        lblPlacarResultado.setText("Total Acertos : x | Total Erros : y");

        txtProvaQuestao.setEditable(false);
        txtProvaQuestao.setColumns(20);
        txtProvaQuestao.setLineWrap(true);
        txtProvaQuestao.setRows(5);
        txtProvaQuestao.setText("\n");
        txtProvaQuestao.setDragEnabled(true);
        jScrollPane2.setViewportView(txtProvaQuestao);

        btnIniciar.setText("Iniciar Teste");
        btnIniciar.setName(""); // NOI18N
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        btnResponder.setText("Respoder");
        btnResponder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResponderActionPerformed(evt);
            }
        });

        gpRbRespostas.add(rbAlternativaA);
        rbAlternativaA.setText("jRadioButton1");

        gpRbRespostas.add(rbAlternativaB);
        rbAlternativaB.setText("jRadioButton2");

        gpRbRespostas.add(rbAlternativaC);
        rbAlternativaC.setText("jRadioButton3");

        gpRbRespostas.add(rbAlternativaD);
        rbAlternativaD.setText("jRadioButton4");

        javax.swing.GroupLayout pnProvaLayout = new javax.swing.GroupLayout(pnProva);
        pnProva.setLayout(pnProvaLayout);
        pnProvaLayout.setHorizontalGroup(
            pnProvaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProvaLayout.createSequentialGroup()
                .addGroup(pnProvaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnProvaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnProvaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbAlternativaA)
                            .addComponent(rbAlternativaB)
                            .addComponent(rbAlternativaC)
                            .addComponent(rbAlternativaD)))
                    .addGroup(pnProvaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnResponder)
                        .addGroup(pnProvaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnProvaLayout.createSequentialGroup()
                                .addComponent(lblProvaQuestao)
                                .addGap(62, 62, 62)
                                .addComponent(lblPlacarResultado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnIniciar))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        pnProvaLayout.setVerticalGroup(
            pnProvaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProvaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnProvaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProvaQuestao)
                    .addComponent(btnIniciar)
                    .addComponent(lblPlacarResultado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(rbAlternativaA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbAlternativaB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbAlternativaC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbAlternativaD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnResponder)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Prova", pnProva);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnResponderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResponderActionPerformed
        // TODO add your handling code here:
        ProvaDAO pD = new ProvaDAO();
        Prova p = new Prova();
        p.setQuestao(questoesCarregadas.get(qualQuestao));
        p.setUsuario(UsuarioLogado.getUserLogado());

        int qualSelecionado = qualSelecionado();
        if (alternativas.get(qualSelecionado).equalsIgnoreCase(questoesCarregadas.get(qualQuestao).getAlt_Certa())) {
            qtdCerta += 1;
            p.setResposta("C");
        } else {
            qtdErrada += 1;
            p.setResposta("E");
        }
        qualQuestao += 1;
        lblProvaQuestao.setText("Questão: " + (qualQuestao + 1));
        lblPlacarResultado.setText("Certas: " + qtdCerta + " | Erradas: " + qtdErrada);
        pD.save(p);
        if (qualQuestao < questoesCarregadas.size()) {
            atualizarAlternativas();

        } else {
            JOptionPane.showMessageDialog(null, "Teste concluido!!!");
            limparCampos();
            btnResponder.setEnabled(false);
        }

        rbAlternativaA.setSelected(false);
        rbAlternativaB.setSelected(false);
        rbAlternativaC.setSelected(false);
        rbAlternativaD.setSelected(false);

    }//GEN-LAST:event_btnResponderActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        // TODO add your handling code here:        
        qualQuestao = 0;
        qtdCerta = 0;
        qtdErrada = 0;
        atualizarQuestoes();
        atualizarAlternativas();

    }//GEN-LAST:event_btnIniciarActionPerformed

    private void atualizarQuestoes() {
        btnResponder.setEnabled(true);
        QuestaoDAO qD = new QuestaoDAO();
        Questao q = new Questao();
        questoesCarregadas = new ArrayList<Questao>();
//        questoesCarregadas.addAll(qD.findByConceitoNaoFeita(UsuarioLogado.getUserLogado().getConceitoUsuario(),
//                10));
        rodaAG();
        if (conA > 0) {
            conceitoA = qD.findByConceitoNaoFeita("A", conA);
            questoesCarregadas.addAll(conceitoA);
        }
        if (conB > 0) {
            conceitoB = qD.findByConceitoNaoFeita("B", conB);
            questoesCarregadas.addAll(conceitoB);
        }
        if (conC > 0) {

            conceitoC = qD.findByConceitoNaoFeita("C", conC);
            questoesCarregadas.addAll(conceitoC);
        }

    }

    private boolean login() {

        UsuarioDAO uD = new UsuarioDAO();

        String usuario, senha;
        usuario = JOptionPane.showInputDialog("Informe o usuario: ");
        senha = JOptionPane.showInputDialog("Informe a senha: ");
        Usuario uTentativa = uD.findByUsuario(usuario);
        if (uTentativa != null) {
            if (uTentativa.getUsuario().equals(usuario) && uTentativa.getSenha().equals(senha)) {
                JOptionPane.showMessageDialog(null, "Login realizado com Sucesso!!");
                UsuarioLogado.setUserLogado(uTentativa);

                System.out.println(UsuarioLogado.getUserLogado().getUsuario());
                return true;
            }
        } else {
            System.out.println("Erro: usuario ou senha invalidos");
        }
        return false;
    }

    private void atualizarAlternativas() {
        try {
            Questao qAtual = questoesCarregadas.get(qualQuestao);
            alternativas = new ArrayList<String>();
            alternativas.add(qAtual.getAlt_1());
            alternativas.add(qAtual.getAlt_2());
            alternativas.add(qAtual.getAlt_3());
            alternativas.add(qAtual.getAlt_Certa());

            Collections.shuffle(alternativas);

            txtProvaQuestao.setText(qAtual.getQuestao());

            rbAlternativaA.setText(alternativas.get(0));
            rbAlternativaB.setText(alternativas.get(1));
            rbAlternativaC.setText(alternativas.get(2));
            rbAlternativaD.setText(alternativas.get(3));

        } catch (IndexOutOfBoundsException eb) {
            JOptionPane.showMessageDialog(null, "Não possui mais questões para você fazer!");
        }

    }

    private int qualSelecionado() {
        int resposta = 0;
        if (rbAlternativaA.isSelected()) {
            resposta = 0;
        }
        if (rbAlternativaB.isSelected()) {
            resposta = 1;
        }
        if (rbAlternativaC.isSelected()) {
            resposta = 2;
        }
        if (rbAlternativaD.isSelected()) {
            resposta = 3;
        }
        return resposta;
    }

    private void limparCampos() {

        lblPlacarResultado.setText("");
        lblProvaQuestao.setText("");

        txtProvaQuestao.setText("");
        rbAlternativaA.setText("");
        rbAlternativaB.setText("");
        rbAlternativaC.setText("");
        rbAlternativaD.setText("");

        rbAlternativaA.setSelected(false);
        rbAlternativaB.setSelected(false);
        rbAlternativaC.setSelected(false);
        rbAlternativaD.setSelected(false);
    }

    public void rodaAG() {
        int questoes[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //Valores são o nivel das questões
        /*
            C facil
            B medio 
            A dificil
        */
        conA = 0;
        conB = 0;
        conC = 0;
        char conceitoQuestao[] = {'B', 'C', 'A', 'B', 'C', 'B', 'C', 'A', 'B', 'C'};
        AG meuGA = new AG(questoes, conceitoQuestao, UsuarioLogado.getUserLogado().getConceitoUsuario().charAt(0));
        meuGA.run(0.01, 100, 5);
        String resposta = "" + meuGA.melhorDeTodos;
        JOptionPane.showMessageDialog(null, "Melhor de Todos: " + meuGA.melhorDeTodos + "\n" + "Com avaliação: " + meuGA.melhorDeTodos.avaliacao());
        for (char cara : resposta.toLowerCase().toCharArray()) {
            if (cara == 'c') {
                conC += 1;
            } else if (cara == 'b') {
                conB += 1;
            } else {
                conA += 1;
            }
        }
    }

    //Variaveis
    public Prova prova = new Prova();
    public List<Questao> questoesCarregadas = new ArrayList<Questao>();
    public int qtdCerta;
    public int qtdErrada;
    public int qualQuestao = 0;
    public Random r = new Random();
    //Tava ArrayList mudei para List
    public List<String> alternativas = new ArrayList<String>();
    public List<Questao> conceitoA = new ArrayList<Questao>();
    public List<Questao> conceitoB = new ArrayList<Questao>();
    public List<Questao> conceitoC = new ArrayList<Questao>();
    public int conA;
    public int conB;
    public int conC;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnResponder;
    private javax.swing.ButtonGroup gpRbRespostas;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblPlacarResultado;
    private javax.swing.JLabel lblProvaQuestao;
    private javax.swing.JPanel pnProva;
    private javax.swing.JRadioButton rbAlternativaA;
    private javax.swing.JRadioButton rbAlternativaB;
    private javax.swing.JRadioButton rbAlternativaC;
    private javax.swing.JRadioButton rbAlternativaD;
    private javax.swing.JTextArea txtProvaQuestao;
    // End of variables declaration//GEN-END:variables

}
