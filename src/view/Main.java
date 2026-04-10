
package view;

import exception.DadosInvalidosException;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import model.Utilizador;

/**
 * Janela principal da aplicação AccessControl. 
 * Esta classe representa a janela principal que aparece depois do login.
 * Mostra o nome do utilizador e o seu perfil na barra de menus. 
 * 
 * Regras de visibilidade do menu:
 *   Administrador → vê "Registar" dentro de Files
 *   Utilizador normal → "Registar" fica oculto (Files aparece vazio)
 *   Todos → Manual visível
 *   Logout → volta ao Home e limpa a sessão
 * 
 * @author Lucas Gonçalves
 * @since 2026-03-17
 */
public class Main extends javax.swing.JFrame {

    private Utilizador utilizadorLogado;

    /**
     * Construtor padrão. 
     * Cria a janela principal sem nenhum utilizador logado.
     * Inicializa os componentes da interface
     */
    public Main() {
        initComponents();
        setTitle("AccessControl - Main" );
        configurarLogout(); // adicionar comportamento ao menu Logout
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    }

    /**
     * Construtor com utilizador. 
     * Cria a janela principal e define o utilizador que já está autenticado. 
     * O utilizador passado será mostrado na barra de menus.
     *
     * @param u Utilizador autenticado (pode ser null).
     */
    public Main(Utilizador u) {
        initComponents();
        configurarLogout();
        setUtilizadorLogado(u);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbImage = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jmFiles = new javax.swing.JMenu();
        jmiRegistar = new javax.swing.JMenuItem();
        jmiListar = new javax.swing.JMenuItem();
        jmManual = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lbImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/AccessControl.png"))); // NOI18N

        jmFiles.setText("Files");
        jmFiles.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jmiRegistar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmiRegistar.setText("Registar");
        jmiRegistar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRegistarActionPerformed(evt);
            }
        });
        jmFiles.add(jmiRegistar);

        jmiListar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmiListar.setText("Listar Utilizadores");
        jmiListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiListarActionPerformed(evt);
            }
        });
        jmFiles.add(jmiListar);

        jMenuBar.add(jmFiles);

        jmManual.setText("Manual");
        jmManual.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmManual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmManualMouseClicked(evt);
            }
        });
        jMenuBar.add(jmManual);

        jMenu1.setText("Logout");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuBar.add(jMenu1);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbImage)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbImage)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // =========================================================
    // LOGOUT
    // =========================================================

    /**
     * Adiciona o comportamento de clique ao menu "Logout".
     * 
     * Como o NetBeans criou como JMenu (não JMenuItem), usamos
     * um MouseListener para capturar o clique nele.
     */
    private void configurarLogout() {
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fazerLogout();
            }
        });
    }
    
    /**
     * Executa o logout: confirma com o utilizador, volta ao Home 
     * Fecha a janela Main atual, limpando a sessão.
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
            utilizadorLogado = null;          // limpa a sessão em memória
            new Home().setVisible(true);   // volta à janela inicial
            dispose();                      // fecha o Main
        }
    }
    
    // =========================================================
    // MENU FILES — visibilidade baseada no perfil
    // =========================================================

    /**
     * Controla a visibilidade dos itens do menu Files.
     * Admin vê "Registar"; 
     * utilizador normal não vê nada.
     *
     * Fazemos isto com setVisible(isAdmin) no jmiRegistar em vez de removeAll(), para não perder a ligação criada pelo NetBeans.
     */
    private void configurarMenus() {
        boolean isAdmin = utilizadorLogado != null && utilizadorLogado.isAdmin();

        // O item "Registar" e "Listar" só aparece para o Administrador
        jmiRegistar.setVisible(isAdmin);
        jmiListar.setVisible(isAdmin);
        jmFiles.setVisible(isAdmin);
    }
    
    /**
     * Mostra o manual da aplicação. 
     * Lê o ficheiro README_ADMIN.txt e README_USER.txt e apresenta o seu conteúdo num diálogo para o Administrador e o Utilizador. 
     * Em caso de erro, mostra uma mensagem ao utilizador ou administrador.
     *
     * @param evt Evento de clique que disparou a ação.
     */

    private void jmManualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmManualMouseClicked
        File manual;
        //escolhe o manual baseado no tipo de utilizador
        if (utilizadorLogado != null && utilizadorLogado.isAdmin()) {
            manual = new File("README_ADMIN.txt");
        } else {
            manual = new File("README_USER.txt");
        }

        if (!manual.exists()) {
            manual = new File("docs/" + manual.getName());
        }

        try {
            String conteudo = new String(java.nio.file.Files.readAllBytes(manual.toPath()), "UTF-8");

            JTextArea ta = new JTextArea(conteudo, 30, 80);
            ta.setEditable(false);
            ta.setFont(new java.awt.Font("Courier New", java.awt.Font.PLAIN, 12));

            JOptionPane.showMessageDialog(this,
                    new JScrollPane(ta),
                    "Manual - AccessControl",
                    JOptionPane.PLAIN_MESSAGE);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Manual não encontrado.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jmManualMouseClicked

    // =========================================================
    // REGISTAR — abre o diálogo de registo de utilizador
    // =========================================================

    /**
     * Chamado quando o Administrador clica em Files > Registar.
     * Abre o diálogo RegistarUtilizadorDialog.
     */
    private void jmiRegistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRegistarActionPerformed
        // Abre o diálogo modal de registo
        // 'this' é o Frame pai, true = modal (bloqueia o Main enquanto aberto)
        RegistarUtilizadorDialog dlg = new RegistarUtilizadorDialog(this, true);
        dlg.setVisible(true);
    }//GEN-LAST:event_jmiRegistarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
         fazerLogout();
    }//GEN-LAST:event_formWindowClosing

    private void jmiListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiListarActionPerformed
        ListarUtilizadoresDialog dlg = new ListarUtilizadoresDialog(this, true);
        dlg.setVisible(true);
    }//GEN-LAST:event_jmiListarActionPerformed
    
    // =========================================================
    // LABEL DO UTILIZADOR LOGADO
    // =========================================================
    /**
     * Atualiza o texto do label que mostra o utilizador logado. 
     * Apenas altera o texto do label e o título da janela para refletir o utilizador atual. 
     * Não modifica a estrutura da barra de menus.
     */
    private void mostrarTipoUtilizador() {
        if (utilizadorLogado != null) {
            String perfilNome = (utilizadorLogado.getPerfil() != null)
                    ? utilizadorLogado.getPerfil().getNomePerfil()
                    : "sem perfil";
            String tipo = utilizadorLogado.isAdmin() ? "Administrador" : "Utilizador";
            setTitle("AccessControl - " + utilizadorLogado.getUsername());
        } else {
            setTitle("AccessControl - Main");
        }
        pack();
    }

    /**
     * Define o utilizador atualmente autenticado e atualiza a interface. 
     * Pode ser null para limpar a sessão.
     *
     * @param u Utilizador autenticado;
     *
     */
    public void setUtilizadorLogado(Utilizador u) {
        this.utilizadorLogado = u;
        mostrarTipoUtilizador();
        configurarMenus();
    }
    /**
     * Ponto de entrada para executar a janela Main diretamente. 
     * Cria e mostra a janela principal na Event Dispatch Thread do Swing.
     *
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            Main JanelaMain = new Main();
            JanelaMain.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jmFiles;
    private javax.swing.JMenu jmManual;
    private javax.swing.JMenuItem jmiListar;
    private javax.swing.JMenuItem jmiRegistar;
    private javax.swing.JLabel lbImage;
    // End of variables declaration//GEN-END:variables
}
