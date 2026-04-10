
package view;

import exception.DadosInvalidosException;
import javax.swing.JOptionPane;
import service.UtilizadorService;


/**
 * Diálogo de registo de novo utilizador.
 * Apenas acessível ao Administrador via Files > Registar Utilizador.
 * 
 * @author Lucas Gonçalves
 * @since 2026-04-09
 * @version 1.0
 */
public class RegistarUtilizadorDialog extends javax.swing.JDialog {

    /**
     * Creates new form RegistarUtilizadorDialog
     */
    public RegistarUtilizadorDialog(java.awt.Frame parent, boolean modal) {
        super(parent, "Registar Novo Utilizador", modal);
        initComponents();
        setLocationRelativeTo(parent);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelRegistar = new javax.swing.JPanel();
        txtNome = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        cmbPerfil = new javax.swing.JComboBox<>();
        btnRegistar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lbRegistar = new javax.swing.JLabel();
        lbRegistar1 = new javax.swing.JLabel();
        lbRegistar2 = new javax.swing.JLabel();
        lbRegistar3 = new javax.swing.JLabel();
        lbRegistar4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cmbPerfil.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Tipo de Perfil --", "Administrador", "Utilizador" }));

        btnRegistar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRegistar.setText("Registar");
        btnRegistar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lbRegistar.setFont(new java.awt.Font("Comic Sans MS", 1, 60)); // NOI18N
        lbRegistar.setText("AccessControl");

        lbRegistar1.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        lbRegistar1.setText("Nome:");

        lbRegistar2.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        lbRegistar2.setText("Adicione aqui um novo Utilizador:");

        lbRegistar3.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        lbRegistar3.setText("Username:");

        lbRegistar4.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        lbRegistar4.setText("Password:");

        javax.swing.GroupLayout jPanelRegistarLayout = new javax.swing.GroupLayout(jPanelRegistar);
        jPanelRegistar.setLayout(jPanelRegistarLayout);
        jPanelRegistarLayout.setHorizontalGroup(
            jPanelRegistarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistarLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(jPanelRegistarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRegistarLayout.createSequentialGroup()
                        .addGroup(jPanelRegistarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbRegistar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbRegistar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelRegistarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPassword)))
                    .addGroup(jPanelRegistarLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanelRegistarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelRegistarLayout.createSequentialGroup()
                                .addComponent(lbRegistar1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNome))
                            .addGroup(jPanelRegistarLayout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addGroup(jPanelRegistarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbRegistar2)
                                    .addComponent(jLabel4))
                                .addGap(0, 127, Short.MAX_VALUE)))))
                .addGap(109, 109, 109))
            .addGroup(jPanelRegistarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRegistarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelRegistarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRegistarLayout.createSequentialGroup()
                        .addComponent(cmbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(259, 259, 259))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRegistarLayout.createSequentialGroup()
                        .addComponent(lbRegistar)
                        .addGap(141, 141, 141))))
        );
        jPanelRegistarLayout.setVerticalGroup(
            jPanelRegistarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistarLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lbRegistar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbRegistar2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRegistarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbRegistar1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRegistarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbRegistar3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRegistarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbRegistar4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(cmbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanelRegistarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelRegistar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRegistar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistarActionPerformed
        registar();
    }//GEN-LAST:event_btnRegistarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed
        private void registar() {
        String nome     = txtNome.getText().trim();
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword()).trim();
        String perfilNome = (String) cmbPerfil.getSelectedItem();

        // Validação local: perfil tem de ser escolhido explicitamente
        // Sem isto, "-- Tipo de Perfil --" seria enviado ao service
        if ("-- Tipo de Perfil --".equals(perfilNome)) {
            JOptionPane.showMessageDialog(this,
                "Por favor seleciona um tipo de perfil.",
                "Perfil não selecionado",
                JOptionPane.WARNING_MESSAGE);
            return; // para aqui, não chama o service
        }
 
        // Converter o nome do perfil nos IDs que a BD usa
        // 1 = Administrador, 2 = Utilizador (conforme o SQL do projeto)
        int perfilId = "Administrador".equals(perfilNome) ? 1 : 2;
        boolean isAdmin = (perfilId == 1);
 
        try {
            // O service faz todas as validações restantes (nome vazio,
            // username vazio, password curta, username duplicado)
            UtilizadorService service = new UtilizadorService();
            service.registarUtilizador(nome, username, password, isAdmin, perfilId);
 
            JOptionPane.showMessageDialog(this,
                "Utilizador \"" + username + "\" registado com sucesso!\nPerfil: " + perfilNome,
                "Registo concluído",
                JOptionPane.INFORMATION_MESSAGE);
 
            limparCampos(); // pronto para registar outro utilizador
 
        } catch (DadosInvalidosException ex) {
            // Mensagem vinda do UtilizadorService ou UtilizadorDAO
            JOptionPane.showMessageDialog(this,
                ex.getMessage(),
                "Erro de validação",
                JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Limpa todos os campos após um registo bem-sucedido.
     * Coloca o foco no primeiro campo para facilitar o próximo registo.
     */
    private void limparCampos() {
        txtNome.setText("");
        txtUsername.setText("");
        txtPassword.setText("");
        cmbPerfil.setSelectedIndex(0); // volta ao placeholder "-- Tipo de Perfil --"
        txtNome.requestFocus();
    }
    
    /**
     * Método principal que inicia a aplicação. 
     * 
     * Responsável por criar e exibir ajanela de registo de utilizador.
     *
     * @param args Argumentos da linha de comandos (não utilizados nesta
     * aplicação).
     */
    public static void main(String args[]) {
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            RegistarUtilizadorDialog dialog = new RegistarUtilizadorDialog(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistar;
    private javax.swing.JComboBox<String> cmbPerfil;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanelRegistar;
    private javax.swing.JLabel lbRegistar;
    private javax.swing.JLabel lbRegistar1;
    private javax.swing.JLabel lbRegistar2;
    private javax.swing.JLabel lbRegistar3;
    private javax.swing.JLabel lbRegistar4;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
