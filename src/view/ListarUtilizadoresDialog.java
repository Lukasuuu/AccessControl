package view;
 
import exception.DadosInvalidosException;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Utilizador;
import service.UtilizadorService;
 
/**
 * Diálogo para listagem e gestão de permissões de utilizadores.
 * Apenas acessível ao Administrador via Files > Listar Utilizadores.
 *
 * Responsabilidades:
 *   - Listar todos os utilizadores registados numa JTable.
 *   - Permitir ao Administrador alterar o perfil de qualquer utilizador.
 *
 * Fluxo (arquitetura 3 camadas):
 *   View (este diálogo) → UtilizadorService → UtilizadorDAO → MySQL
 *
 * @author Lucas Gonçalves
 * @since 2026-04-10
 * @version 1.0
 */
public class ListarUtilizadoresDialog extends JDialog {
 
    // =========================================================
    // ATRIBUTOS
    // =========================================================
 
    /** Camada de serviço — nunca chama o DAO diretamente. */
    private final UtilizadorService utilizadorService = new UtilizadorService();
 
    /** Modelo da tabela que guarda as linhas exibidas. */
    private DefaultTableModel modeloTabela;
 
    /** Tabela visual de utilizadores. */
 
    /**
     * Lista em memória dos utilizadores carregados.
     * Usada para obter o objeto Utilizador correspondente à linha selecionada.
     */
    private List<Utilizador> listaUtilizadores;
 
    /** ComboBox para escolher o novo perfil ao atualizar permissão. */
    private JComboBox<String> cmbNovoPerfil;
 
    // =========================================================
    // CONSTRUTOR
    // =========================================================
 
    /**
     * Cria o diálogo modal de listagem de utilizadores.
     *
     * @param parent Frame pai (Main.java).
     * @param modal  true para bloquear a janela principal enquanto aberto.
     */
    public ListarUtilizadoresDialog(java.awt.Frame parent, boolean modal) {
        super(parent, "Utilizadores Registados", modal);
        initComponents();
        
        modeloTabela = (DefaultTableModel) tabelaUtilizadores.getModel();
        carregarUtilizadores();
        setLocationRelativeTo(parent);
    }
 
    // =========================================================
    // INICIALIZAÇÃO DE COMPONENTES (escrita à mão — sem NetBeans)
    // =========================================================
 
    /**
     * Constrói e organiza todos os componentes gráficos do diálogo.
     * Layout: BorderLayout com título (NORTH), tabela (CENTER) e painel de ações (SOUTH).
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaUtilizadores = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabelaUtilizadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Username", "Tipo de Permissão"
            }
        ));
        jScrollPane1.setViewportView(tabelaUtilizadores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
// =========================================================
    // CARREGAR UTILIZADORES (View chama Service)
    // =========================================================

    /**
     * Carrega todos os utilizadores via Service e preenche a JTable.
     * Limpa sempre a tabela antes de carregar para evitar duplicados em atualizações.
     */
    private void carregarUtilizadores() {
        modeloTabela.setRowCount(0); // limpa todas as linhas existentes

        try {
            // View chama Service — nunca chama UtilizadorDAO diretamente
            listaUtilizadores = utilizadorService.listarUtilizadores();

            for (Utilizador u : listaUtilizadores) {
                modeloTabela.addRow(new Object[]{
                    u.getId(),
                    u.getUsername(),
                    u.getPerfil().getNomePerfil(),
                    u.isAdmin() ? "Sim" : "Não"
                });
            }

        } catch (DadosInvalidosException e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar utilizadores:\n" + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // =========================================================
    // ATUALIZAR PERMISSÃO (ação sobre linha selecionada)
    // =========================================================

    /**
     * Atualiza o perfil e flag is_admin do utilizador selecionado na tabela.
     *
     * Fluxo:
     *   1. Verifica se uma linha está selecionada.
     *   2. Obtém o Utilizador correspondente da lista em memória.
     *   3. Confirma a alteração com o Administrador.
     *   4. Chama o Service → DAO → MySQL.
     *   5. Refresca a tabela com os dados atualizados.
     */
    private void atualizarPermissao() {
        int linhaSelecionada = tabelaUtilizadores.getSelectedRow();

        // Verificar se alguma linha está selecionada
        if (linhaSelecionada < 0) {
            JOptionPane.showMessageDialog(this,
                    "Por favor seleciona um utilizador na tabela antes de atualizar.",
                    "Nenhum utilizador selecionado",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Obter o Utilizador da lista em memória (índice == linha da tabela)
        Utilizador utilizadorSelecionado = listaUtilizadores.get(linhaSelecionada);

        // Obter novo perfil escolhido no ComboBox
        String novoPerfilNome = (String) cmbNovoPerfil.getSelectedItem();
        int novoPerfilId = "Administrador".equals(novoPerfilNome) ? 1 : 2;
        boolean novoIsAdmin = (novoPerfilId == 1);

        // Confirmar alteração com o Administrador
        int confirmacao = JOptionPane.showConfirmDialog(this,
                "Alterar perfil de \"" + utilizadorSelecionado.getUsername()
                + "\" para " + novoPerfilNome + "?",
                "Confirmar alteração",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (confirmacao != JOptionPane.YES_OPTION) {
            return; // Administrador cancelou
        }

        try {
            // View chama Service — quem valida os IDs é o Service
            utilizadorService.atualizarPermissao(
                    utilizadorSelecionado.getId(), novoPerfilId, novoIsAdmin);

            JOptionPane.showMessageDialog(this,
                    "Permissão de \"" + utilizadorSelecionado.getUsername()
                    + "\" atualizada para " + novoPerfilNome + ".",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);

            carregarUtilizadores(); // refrescar tabela após alteração

        } catch (DadosInvalidosException e) {
            JOptionPane.showMessageDialog(this,
                    e.getMessage(),
                    "Erro de validação",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaUtilizadores;
    // End of variables declaration//GEN-END:variables
}
