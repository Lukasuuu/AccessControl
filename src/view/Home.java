/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JOptionPane;

/**
 * Janela principal de boas-vindas da aplicação AccessControl.
 *
 * É a primeira janela apresentada ao utilizador ao iniciar a aplicação.
 * Contém uma mensagem de apresentação e um botão que redireciona para
 * o ecrã de autenticação ({@link Login}).
 *
 * @author Lucas Gonçalves
 * @since 2026-03-17
 */
public class Home extends javax.swing.JFrame {

   /**
     * Construtor padrão. Inicializa e configura os componentes visuais da janela.
     */
    public Home() {
        initComponents();
        setTitle("AccessControl - Home");
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBemVindo = new javax.swing.JButton();
        lbLogin = new javax.swing.JLabel();
        lbLogin1 = new javax.swing.JLabel();
        CmbHome = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBemVindo.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnBemVindo.setText("Aceder ao Sistema");
        btnBemVindo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBemVindoActionPerformed(evt);
            }
        });

        lbLogin.setFont(new java.awt.Font("Comic Sans MS", 1, 48)); // NOI18N
        lbLogin.setText("AccessControl");

        lbLogin1.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        lbLogin1.setText("Soluções modernas para autenticação e controlo de acessos.");

        CmbHome.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CmbHome.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "            -- Selecione um perfil --", "Administrador", "Utilizador" }));
        CmbHome.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(lbLogin))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbLogin1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(btnBemVindo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 136, Short.MAX_VALUE)
                .addComponent(CmbHome, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(lbLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CmbHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(btnBemVindo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * Ação do botão "Aceder ao Sistema".
     * Invoca {@link #chamarLogin()} para navegar para o ecrã de autenticação.
     *
     * @param evt Evento de ação gerado pelo clique no botão.
     */
    private void btnBemVindoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBemVindoActionPerformed
        
        String perfilEscolhido = (String) CmbHome.getSelectedItem();
        // Verificar se o utilizador ainda não escolheu um perfil
        if (perfilEscolhido.equals("            -- Selecione um perfil --")) {
            JOptionPane.showMessageDialog(this,
                    "Por favor seleciona um perfil antes de continuar.",
                    "Perfil não selecionado",
                    JOptionPane.WARNING_MESSAGE);
            return; // para aqui, não abre o Login
        }

        // Se chegou aqui, já escolheu um perfil válido
        Login janelaLogin = new Login(perfilEscolhido);
        janelaLogin.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBemVindoActionPerformed

    /**
     * Ponto de entrada da aplicação.
     * <p>
     * Aplica o Look and Feel Nimbus (se disponível) e inicializa
     * a janela principal na Event Dispatch Thread do Swing.
     *
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Home().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CmbHome;
    private javax.swing.JButton btnBemVindo;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JLabel lbLogin1;
    // End of variables declaration//GEN-END:variables
}
