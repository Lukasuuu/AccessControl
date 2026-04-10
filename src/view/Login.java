
package view;

import exception.DadosInvalidosException;
import javax.swing.JOptionPane;
import model.Perfil;
import model.Utilizador;
import service.UtilizadorService;

/**
 * Classe Login - Interface gráfica para autenticação de utilizadores. Permite o
 * acesso ao sistema BookManager mediante nome de utilizador e senha válidos.
 * Após login bem-sucedido, redireciona para a tela principal.
 *
 * Esta classe utiliza Swing (JFrame) e foi parcialmente gerada por IDE.
 *
 * @author Lucas Gonçalves
 * @since 2026-03-17
 */
public class Login extends javax.swing.JFrame {

    private final UtilizadorService utilizadorService = new UtilizadorService();

    // String de Perfil
    private String perfilSelecionado;

    /**
     * Construtor padrão da janela de login.
     * @param perfilSelecionado
     */
    public Login(String perfilSelecionado) {
        this.perfilSelecionado = perfilSelecionado; // guardar o perfil recebido
        initComponents();
        getRootPane().setDefaultButton(btnGuardar);
        setLocationRelativeTo(null);
        setTitle("AccessControl - Login (" + perfilSelecionado + ")"); // mostra o perfil no título
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        passwordPanel = new javax.swing.JPanel();
        lbPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lbNome = new javax.swing.JLabel();
        txtUtilizador = new javax.swing.JFormattedTextField();
        btnGuardar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        lbLogin = new javax.swing.JLabel();
        lbLogin1 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lbPassword.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lbPassword.setText("Senha:");

        lbNome.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lbNome.setText("Utilizador:");

        btnGuardar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnGuardar.setText("Entrar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        lbLogin.setFont(new java.awt.Font("Comic Sans MS", 1, 48)); // NOI18N
        lbLogin.setText("AccessControl");

        lbLogin1.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        lbLogin1.setText("Faça seu Login:");

        javax.swing.GroupLayout passwordPanelLayout = new javax.swing.GroupLayout(passwordPanel);
        passwordPanel.setLayout(passwordPanelLayout);
        passwordPanelLayout.setHorizontalGroup(
            passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordPanelLayout.createSequentialGroup()
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, passwordPanelLayout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addComponent(lbPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(passwordPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(passwordPanelLayout.createSequentialGroup()
                                    .addComponent(lbNome)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtUtilizador, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(passwordPanelLayout.createSequentialGroup()
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(passwordPanelLayout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(lbLogin1))
                    .addGroup(passwordPanelLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(lbLogin)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        passwordPanelLayout.setVerticalGroup(
            passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUtilizador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(passwordPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(passwordPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Faz o login no sistema. - 
     * Lê os campos da tela - Chama o UtilizadorDAO atraves da Classe utilizadorService
     *
     * Validado no banco de dados corretament - Abre a tela principal 
     *     - Se der errado, mostra mensagem e não abre o sistema
     */
    private void fazerLogin() {
        // Ler os campos
        String username = txtUtilizador.getText().trim();
        String password = new String(txtPassword.getPassword()).trim();

        try {
            // Autenticar utilizador
            Utilizador u = utilizadorService.autenticar(username, password);

            // Verificar se login falhou
            if (u == null) {
                JOptionPane.showMessageDialog(this,
                        "Utilizador ou senha inválidos. Tente novamente.",
                        "Login inválido",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Obter perfil
            Perfil perfil = u.getPerfil();
            String nomePerfil = perfil.getNomePerfil();

            // Verificar perfil selecionado
            if (!nomePerfil.equalsIgnoreCase(perfilSelecionado)) {
                JOptionPane.showMessageDialog(this,
                        "Esta conta é do tipo \"" + nomePerfil + "\".\n"
                        + "Volta ao início e seleciona o perfil correto.",
                        "Perfil incorreto",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Mensagem conforme perfil
            if (nomePerfil.equalsIgnoreCase("Administrador")) {
                JOptionPane.showMessageDialog(this,
                        "Bem-vindo Administrador " + u.getUsername(),
                        "Acesso Total",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Bem-vindo " + u.getUsername(),
                        "Acesso Limitado",
                        JOptionPane.INFORMATION_MESSAGE);
            }

            // Abrir sistema (Main) e passar o utilizador autenticado
            Main janelaMain = new Main(); 
            janelaMain.setUtilizadorLogado(u); // u é o Utilizador retornado pelo service/DAO
            janelaMain.setVisible(true);
            dispose(); // fecha o login

        } catch (DadosInvalidosException ex) {
            // Erros de validação
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Erro de validação",
                    JOptionPane.WARNING_MESSAGE);
        }
    }
    
    /**
     * Ação do botão Entrar (antes chamado btnGuardar)
     */
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        fazerLogin();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        fazerLogout();
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        fazerLogout();
    }//GEN-LAST:event_formWindowClosing
    /**
     * Executa o logout: confirma com o utilizador 
     * Fecha a janela Login atual, limpando a sessão.
     */
    private void fazerLogout() {
        int resposta = JOptionPane.showConfirmDialog(
                this,
                "Tens a certeza que queres sair?",
                "Confirmar Logout",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (resposta == JOptionPane.YES_OPTION) {
            new Home().setVisible(true); // volta ao início
            dispose(); // fecha a janela atual
        }
    }
    /**
     * Ponto de entrada para iniciar a aplicação pelo ecrã de login.
     *
     * Inicializa a janela {@link Login}
     * Event Dispatch Thread do Swing, garantindo a segurança de threads na interface gráfica.
     *
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String args[]) {
        // O Login nunca abre sozinho — primeiro vai ao Home,
        // onde o utilizador escolhe o perfil e só depois chega aqui.
        java.awt.EventQueue.invokeLater(() -> {
            new Home().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSair;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JLabel lbLogin1;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbPassword;
    private javax.swing.JPanel passwordPanel;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JFormattedTextField txtUtilizador;
    // End of variables declaration//GEN-END:variables

}
